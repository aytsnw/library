package com.aytsnw.session;

import com.aytsnw.models.User;

import java.util.HashMap;

public class SessionManager {
    public static HashMap<String, String> session = new HashMap<>();

    public static void addUserToSession(User user){
        session.put("user_id", user.getId().toString());
        session.put("username", user.getUsername());
        session.put("level", user.getLevel());
    }
}
