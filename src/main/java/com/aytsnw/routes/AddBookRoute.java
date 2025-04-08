package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.devices.ScreenDisplayer;

import javax.swing.*;
import java.util.HashMap;

public class AddBookRoute extends Route {
    HashMap<String, String> fields = new HashMap<>();

    void fillFields(){
        fields.put("title", "Title");
        fields.put("author", "Author");
        fields.put("isbn", "ISBN code");
        fields.put("publisher", "Publisher");
        fields.put("year", "Publication Year");
        fields.put("category", "Category");
    }

    public AddBookRoute(String name) {
        super(name);
    }

    @Override
    protected void init() {
        fillFields();
        elements.put("fields", fields);
    }

    @Override
    public void process(HashMap<String, String> screenParams) {
        init();

        String title = screenParams.get("title");
        String author = screenParams.get("author");
        String isbn = screenParams.get("isbn");
        String publisher = screenParams.get("publisher");
        String year = screenParams.get("year");
        String category = screenParams.get("category");


        renderScreen("added", elements);
    }

    @Override
    public void process() {
        init();
        renderScreen("add", elements);
    }

    @Override
    public void renderScreen(String screenName, HashMap<String, Object> innerParams) {
        ScreenDisplayer.displayScreen("add", innerParams);
    }

    @Override
    public void renderScreen() {
        ScreenDisplayer.displayScreen("added");
    }
}
