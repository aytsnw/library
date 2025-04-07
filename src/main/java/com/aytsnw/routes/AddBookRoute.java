package com.aytsnw.routes;

import com.aytsnw.ui.ScreenDisplayer;

import java.util.ArrayList;
import java.util.HashMap;

public class AddBookRoute extends Route{
    HashMap<String, String> fields = new HashMap<>();

    void fillFields(){
        fields.put("title", "Title");
        fields.put("author", "Author");
        fields.put("isbn", "ISBN code");
        fields.put("year", "Publication Year");
        fields.put("category", "Category");
    }

    public AddBookRoute(String name) {
        super(name);
    }

    @Override
    void init() {
        fillFields();
        elements.put("fields", fields);
    }

    @Override
    public void process(HashMap<String, Object> params) {
        init();
        renderScreen(elements);
    }

    @Override
    public void process() {
        init();
        renderScreen(elements);
    }

    @Override
    public void renderScreen(HashMap<String, Object> params) {
        ScreenDisplayer.displayScreen("add", params);
    }

    @Override
    public void renderScreen() {

    }
}
