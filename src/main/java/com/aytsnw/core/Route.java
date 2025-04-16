package com.aytsnw.core;

import com.aytsnw.devices.ScreenDisplayer;

import java.util.HashMap;

public abstract class Route {
    public static HashMap<String, Route> routes = new HashMap<>();

    String name;
    protected HashMap<String, Object> elements = new HashMap<>();

    public Route (String name){
        this.name = name;
        routes.put(name, this);
    }

    public void renderScreen(String screenName, HashMap<String, Object> innerParams) {
        ScreenDisplayer.displayScreen(screenName, innerParams);
    }

    public void renderScreen(String screenName) {
        ScreenDisplayer.displayScreen(screenName);
    }

    protected abstract void init();

    public abstract void process(HashMap<String, Object> screenParams);

    public abstract void process();

}
