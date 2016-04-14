package com.pccw.lizhihui.cmcc.data.cache;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.inject.Inject;

/**
 * Created by lizhihui on 4/13/16.
 */
public class FileManager {
    @Inject
    public FileManager(){}

    public String readFileContent(File userEntityFile) {
        return null;
    }

    public void writeToPreferences(Context context, String preferenceFileName, String key,
                                   long value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void writeToFile(File file, String fileContent) {
        if (!file.exists()) {
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(fileContent);
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }

    public boolean exists(File file) {
        return file.exists();
    }

    public boolean delete(File file){
        return file.delete();
    }
}
