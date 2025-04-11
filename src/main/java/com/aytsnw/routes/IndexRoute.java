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
        options.add("Add book");
        options.add("Remove book");
        options.add("Borrow book");
        options.add("Return book");
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

    void validateChoice(int choice, int min, int max) throws InvalidInputException {
        System.out.println("options size: " + max);
        if (choice < min || choice > max){
            throw new InvalidInputException();
        }
    }

    @Override
    public void renderScreen(String screenName, HashMap<String, Object> innerParams) {
        ScreenDisplayer.displayScreen("main", innerParams);
    }

    @Override
    public void renderScreen(String screeName) {
        ScreenDisplayer.displayScreen("main");
    }
}
