package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbWriter;
import com.aytsnw.devices.ScreenDisplayer;

import java.sql.SQLException;
import java.util.HashMap;

public class RemoveBookRoute extends Route {
    public RemoveBookRoute(String name) {
        super(name);
    }

    @Override
    protected void init() {}

    @Override
    public void process(HashMap<String, Object> screenParams) {
        init();
        try{
            DbWriter.deleteFromBooks((String) screenParams.get("id"));
        } catch (SQLException ex){
            System.out.println("SQL Error: couldn't delete from 'books' table");
            System.out.println(ex.getMessage());
            elements.put("message", ex.getMessage());
            renderScreen("remove_book", elements);
            return;
        }
        elements.put("message", "Book removed successfully");
        renderScreen("remove_book", elements);
    }

    @Override
    public void process() {

    }

    @Override
    protected void renderScreen(String screenName, HashMap<String, Object> innerParams) {
        ScreenDisplayer.displayScreen("book_removed", innerParams);
    }

    @Override
    protected void renderScreen(String screeName) {

    }
}
