package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.devices.ScreenDisplayer;
import com.aytsnw.session.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;

public class IndexRoute extends Route {

    public IndexRoute(String name) {
        super(name);
    }

    @Override
    public void process(HashMap<String, Object> screenParams) {
        System.out.println(SessionManager.session.get("username"));
        System.out.println(SessionManager.session.get("level"));
        renderScreen("main", elements);
    }

    @Override
    public void process() {
        System.out.println(SessionManager.session.get("level"));
        elements.put("username", SessionManager.session.get("username"));
        renderScreen("main", elements);}
}
