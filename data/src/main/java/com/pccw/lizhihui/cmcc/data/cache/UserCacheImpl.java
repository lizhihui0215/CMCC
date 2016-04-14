package com.pccw.lizhihui.cmcc.data.cache;

import android.content.Context;

import com.pccw.lizhihui.cmcc.data.cache.serializer.UserJSONSerializer;
import com.pccw.lizhihui.cmcc.data.exception.CacheUserException;
import com.pccw.lizhihui.cmcc.domain.User;
import com.pccw.lizhihui.cmcc.data.exception.UserNotFoundException;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by lizhihui on 3/16/16.
 *
 */
@Singleton
public class UserCacheImpl implements UserCache {

    private static final String SETTINGS_FILE_NAME = "com.fernandocejas.android10.SETTINGS";

    private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "last_cache_update";
    private static final String DEFAULT_FILE_NAME = "user_";

    private final Context context;
    private final File cacheDir;
    private final FileManager fileManager;
    private final ThreadExecutor threadExecutor;
    private final UserJSONSerializer userJSONSerializer;

    @Inject
    public UserCacheImpl(Context context, UserJSONSerializer userJSONSerializer,
                         FileManager fileManager, ThreadExecutor threadExecutor){
        if (context == null || userJSONSerializer == null ||
                fileManager == null || threadExecutor == null){
            throw new IllegalArgumentException("Invalid null parameter");
        }
        this.userJSONSerializer = userJSONSerializer;
        this.context = context.getApplicationContext();
        this.cacheDir = this.context.getCacheDir();
        this.fileManager = fileManager;
        this.threadExecutor = threadExecutor;
    }


    @Override
    public Observable<User> get(String account, String password) {
        return Observable.create(subscriber -> {
            File userEntityFile = UserCacheImpl.this.buildFile(account);
            String fileContent = UserCacheImpl.this.fileManager.readFileContent(userEntityFile);
            User user = UserCacheImpl.this.userJSONSerializer.deserialize(fileContent);

            if (user != null){
                subscriber.onNext(user);
                subscriber.onCompleted();
            }else {
                subscriber.onError(new UserNotFoundException());
            }
        });
    }

    @Override
    public void put(User user) throws Exception{
        if (user != null){
            File userEntityFile = this.buildFile(user.getAccount());
            if (isCached(user.getAccount())){
//                this.fileManager.delete(userEntityFile)
                if(false){
                    String jsonString = this.userJSONSerializer.serialize(user);
                    this.executeAsynchronously(new CacheWriter(this.fileManager, userEntityFile,
                            jsonString));
                    setLastCacheUpdateTimeMillis();
                }else {
                    throw new CacheUserException();
                }
            }

        }
    }
    private static class CacheWriter implements Runnable {
        private final FileManager fileManager;
        private final File fileToWrite;
        private final String fileContent;

        CacheWriter(FileManager fileManager, File fileToWrite, String fileContent) {
            this.fileManager = fileManager;
            this.fileToWrite = fileToWrite;
            this.fileContent = fileContent;
        }

        @Override public void run() {
            this.fileManager.writeToFile(fileToWrite, fileContent);
        }
    }
    private void setLastCacheUpdateTimeMillis() {
        long currentMillis = System.currentTimeMillis();
        this.fileManager.writeToPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE, currentMillis);
    }

    private void executeAsynchronously(Runnable runnable) {
        this.threadExecutor.execute(runnable);
    }

    private boolean isCached(String account) {
        File userEntitiyFile = this.buildFile(account);
        return this.fileManager.exists(userEntitiyFile);
    }


    private File buildFile(String account) {
        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(this.cacheDir.getPath());
        fileNameBuilder.append(File.separator);
        fileNameBuilder.append(DEFAULT_FILE_NAME);
        fileNameBuilder.append(account);

        return new File(fileNameBuilder.toString());
    }
}
