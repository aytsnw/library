package com.aytsnw.routes;

import com.aytsnw.core.Route;

import java.util.HashMap;

public class ExitRoute extends Route {
    public ExitRoute(String name) {super(name);}

    @Override
    public void process(HashMap<String, Object> screenParams) {}

    @Override
    public void process() {System.exit(0);}
}
