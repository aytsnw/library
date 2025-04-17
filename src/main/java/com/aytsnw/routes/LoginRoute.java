package com.aytsnw.routes;

import com.aytsnw.core.Route;

import java.util.HashMap;

public class LoginRoute extends Route {
    public LoginRoute(String name) {super(name);}

    @Override
    public void process(HashMap<String, Object> screenParams) {
        renderScreen("login");
    }

    @Override
    public void process() {
        renderScreen("login");
    }
}
