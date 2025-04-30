package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbWriter;

import java.sql.SQLException;
import java.util.HashMap;

public class RemoveBookRoute extends Route {
    public RemoveBookRoute(String name) {super(name);}

    @Override
    public void process(HashMap<String, Object> screenParams) {
        try{
            DbWriter.deleteFromBooks((Integer) screenParams.get("book_id"));
        } catch (SQLException ex){
            System.out.println("SQL Error: couldn't delete from 'books' table");
            System.out.println(ex.getMessage());
            elements.put("message", "Error deleting book.");
            renderScreen("error", elements);
            ex.printStackTrace();
            return;
        }
        elements.put("message", "Book removed successfully");
        renderScreen("book_removed", elements);
    }

    @Override
    public void process() {}
}
