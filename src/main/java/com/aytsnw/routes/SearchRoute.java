package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbReader;
import com.aytsnw.devices.BookValidator;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.models.Book;
import com.aytsnw.session.SessionManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchRoute extends Route {

    public SearchRoute(String name) {super(name);}

    @Override
    public void process(HashMap<String, Object> screenParams) {
        String type, query = null;
        String message = "";

        try {
            type = (String) screenParams.get("type");
            query = (String) screenParams.get("entry");
            if (type.equals("title")) BookValidator.validateTitle(query);
            else if (type.equals("isbn")) BookValidator.validateIsbn(query);
        } catch (InvalidInputException ex){
            renderErrorScreen(ex.getMessage());
            return;
        }

        ArrayList<Book> bookRows = null;

        try{
            bookRows = DbReader.readFromBooks(type, query);
        } catch (SQLException | InvalidInputException ex){
            System.out.println(ex.getMessage());
            renderErrorScreen("SQL Error: Couldn't Select from db.");
            return;
        }

        elements.put("book_rows", bookRows);
        elements.put("user_id", SessionManager.session.get("user_id"));
        elements.put("message", message);
        elements.put("index", 0);
        elements.put("query", query);

        renderScreen("search_results", elements);
    }

    @Override
    public void process() {renderScreen("search_book");}
}
