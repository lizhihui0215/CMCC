package com.pccw.lizhihui.cmcc.data.cache.serializer;

import com.google.gson.Gson;
import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lizhihui on 4/13/16.
 */
@Singleton
public class UserJSONSerializer {
    private final Gson gson = new Gson();


    @Inject
    public UserJSONSerializer(){}

    public String serialize(UserEntity user){
        String jsonString = gson.toJson(user, UserEntity.class);
        return jsonString;
    }

    public UserEntity deserialize(String jsonString){
        UserEntity user = gson.fromJson(jsonString, UserEntity.class);
        return user;
    }

}
