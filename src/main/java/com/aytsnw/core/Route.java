package com.aytsnw.core;

import java.util.HashMap;

public abstract class Route {
    public static HashMap<String, Route> routes = new HashMap<>();

    String name;
    protected HashMap<String, Object> elements = new HashMap<>();

    public Route (String name){
        this.name = name;
        routes.put(name, this);
    }

    protected abstract void init();

    public abstract void process(HashMap<String, String> screenParams);

    public abstract void process();

    protected abstract void renderScreen(String screenName, HashMap<String, Object> innerParams);

    protected abstract void renderScreen();
}
