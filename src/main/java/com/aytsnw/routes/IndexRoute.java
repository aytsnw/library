package com.aytsnw.routes;

import com.aytsnw.ui.ScreenDisplayer;

import java.util.ArrayList;
import java.util.HashMap;

public class IndexRoute extends Route{
    ArrayList<String> options = new ArrayList<>();

    public IndexRoute(String name) {
        super(name);
    }

    void fillOptions(){
        options.add("1. Add book");
        options.add("2. Remove book");
        options.add("3. Borrow book");
        options.add("4. Return book");
    }

    @Override
    public void process(HashMap<String, Object> params) {
        fillOptions();
        elements.put("options", options);
        renderScreen(elements);
    }

    @Override
    public void renderScreen(HashMap<String, Object> params) {
        ScreenDisplayer.display("main", params);
    }
}
