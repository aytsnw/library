package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.devices.ScreenDisplayer;

import java.util.ArrayList;
import java.util.HashMap;

public class IndexRoute extends Route {

    public IndexRoute(String name) {
        super(name);
    }

    @Override
    public void process(HashMap<String, Object> screenParams) {
        renderScreen("main", elements);
    }

    @Override
    public void process() {
        renderScreen("main", elements);
    }
}
