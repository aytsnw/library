package com.aytsnw.routes;

import java.util.HashMap;

public abstract class Route {
    public static HashMap<String, Route> routes = new HashMap<>();

    private String name;
    HashMap<String, Object> elements = new HashMap<>();

    public Route (String name){
        this.name = name;
        routes.put(name, this);
    }

    abstract void init();

    public abstract void process(HashMap<String, Object> params);

    public abstract void process();

    public abstract void renderScreen(HashMap<String, Object> params);

    public abstract void renderScreen();
}
