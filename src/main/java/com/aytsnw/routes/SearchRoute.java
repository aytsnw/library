package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbReader;
import com.aytsnw.devices.BookValidator;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.models.Book;

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
            if (type.equals("title")){
                BookValidator.validateTitle(query);}
            else if (type.equals("isbn")){
                BookValidator.validateIsbn(query);}
        } catch (InvalidInputException ex){
            renderErrorScreen("Empty parameter!");
            return;
        }

        ArrayList<Book> bookRows = null;

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
        elements.put("index", screenParams.getOrDefault("index", 0));

        renderScreen("search_results", elements);
    }

    @Override
    public void process() {renderScreen("search_book");}
}
