package com.pccw.lizhihui.cmcc.data.cache.serializer;

import com.google.gson.Gson;

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

    public String serialize(User user){
        String jsonString = gson.toJson(user, User.class);
        return jsonString;
    }

    public User deserialize(String jsonString){
        User user = gson.fromJson(jsonString, User.class);
        return user;
    }

}
