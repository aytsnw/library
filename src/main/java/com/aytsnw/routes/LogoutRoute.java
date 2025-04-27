package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.devices.Alternator;
import com.aytsnw.session.SessionManager;

import java.util.HashMap;

public class LogoutRoute extends Route {
    public LogoutRoute(String name) {super(name);}

    @Override
    public void process(HashMap<String, Object> screenParams) {}

    @Override
    public void process() {
        SessionManager.session.clear();
        Alternator.alternateRoute("login");
    }
}
