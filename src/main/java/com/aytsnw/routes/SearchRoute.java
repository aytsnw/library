package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbReader;
import com.aytsnw.devices.Validator;
import com.aytsnw.exceptions.InvalidInputException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchRoute extends Route {

    public SearchRoute(String name) {super(name);}

    @Override
    public void process(HashMap<String, Object> screenParams) {
        String type = null;
        String query = null;
        String message = "";

        try {
            type = (String) screenParams.get("type");
            query = (String) screenParams.get("entry");
            if (type.equals("title")){Validator.validateTitle(query);}
            else if (type.equals("isbn")){Validator.validateIsbn(query);}
        } catch (InvalidInputException ex){
            message = "Empty parameter!";
            elements.put("message", message);
            renderScreen("error", elements);
            return;
        }

        ArrayList<HashMap<String, Object>> bookRows = null;

        try{
            bookRows = DbReader.readFromBooks(type, query);
        } catch (SQLException ex){
            message = "SQL Error: Couldn't Select from db.";
            System.out.println(ex.getMessage());
            elements.put("message", message);
            renderScreen("error", elements);
            return;
        }

        elements.put("book_rows", bookRows);
        elements.put("message", message);

        renderScreen("search_results", elements);
    }

    @Override
    public void process() {renderScreen("search_book");}
}
