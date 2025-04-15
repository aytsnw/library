package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbReader;
import com.aytsnw.devices.ScreenDisplayer;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchRoute extends Route {

    public SearchRoute(String name) {
        super(name);
    }

    @Override
    protected void init() {

    }

    @Override
    public void process(HashMap<String, Object> screenParams) {
        init();
        String type = null;
        String entry = null;
        try {
            type = (String) screenParams.get("type");
            entry = (String) screenParams.get("entry");
        } catch (NullPointerException ex) {
            System.out.println("Search option not found.");
            ex.printStackTrace();
            return;
        }

        ArrayList<HashMap<String, Object>> rows = null;

        try{
            rows = DbReader.readFromBooks(type, entry);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        elements.put("rows", rows);

        renderScreen("search_results", elements);
    }

    @Override
    public void process() {
        init();
        renderScreen("search");
    }

    @Override
    protected void renderScreen(String screenName, HashMap<String, Object> innerParams) {
        ScreenDisplayer.displayScreen(screenName, innerParams);
    }

    @Override
    protected void renderScreen(String screenName) {
        ScreenDisplayer.displayScreen(screenName);
    }
}
