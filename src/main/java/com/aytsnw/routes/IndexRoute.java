package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.devices.ScreenDisplayer;

import java.util.ArrayList;
import java.util.HashMap;

public class IndexRoute extends Route {
    ArrayList<String> options = new ArrayList<>();

    public IndexRoute(String name) {
        super(name);
    }

    void fillOptions(){
        options.add("Add Book");
        options.add("Search Book");
        options.add("Exit");
    }

    @Override
    protected void init(){
        fillOptions();
    }

    @Override
    public void process(HashMap<String, Object> screenParams) {
        init();
        elements.put("options", options);
        renderScreen("main", elements);
    }

    @Override
    public void process() {
        init();
        elements.put("options", options);
        renderScreen("main", elements);
    }
}
