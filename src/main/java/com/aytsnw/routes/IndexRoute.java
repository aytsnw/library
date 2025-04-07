package com.aytsnw.routes;

import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.ui.ScreenDisplayer;

import java.util.ArrayList;
import java.util.HashMap;

public class IndexRoute extends Route{
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
    void init(){
        fillOptions();
    }

    @Override
    public void process(HashMap<String, Object> params) {
        init();
        elements.put("options", options);
        renderScreen(elements);
    }

    @Override
    public void process() {
        init();
        elements.put("options", options);
        renderScreen(elements);
    }

    void validateChoice(int choice, int min, int max) throws InvalidInputException {
        System.out.println("options size: " + max);
        if (choice < min || choice > max){
            throw new InvalidInputException();
        }
    }

    @Override
    public void renderScreen(HashMap<String, Object> params) {
        ScreenDisplayer.displayScreen("main", params);
    }

    @Override
    public void renderScreen() {
        ScreenDisplayer.displayScreen("main");
    }
}
