package com.aytsnw.core;

import com.aytsnw.devices.ScreenDisplayer;

import java.util.HashMap;

public abstract class Route {
    public static HashMap<String, Route> routes = new HashMap<>();

    String name;
    protected HashMap<String, Object> elements = new HashMap<>();

    protected Route (String name){
        this.name = name;
        routes.put(name, this);
    }

    protected void renderScreen(String screenName, HashMap<String, Object> innerParams) {
        ScreenDisplayer.displayScreen(screenName, innerParams);
    }

    protected void renderScreen(String screenName) {
        ScreenDisplayer.displayScreen(screenName);
    }

    protected void renderErrorScreen(String message){
        ScreenDisplayer.displayErrorScreen(message);
    }

    public abstract void process(HashMap<String, Object> screenParams);

    public abstract void process();

}
