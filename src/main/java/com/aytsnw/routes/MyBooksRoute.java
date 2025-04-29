package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbReader;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.models.Book;
import com.aytsnw.session.SessionManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MyBooksRoute extends Route {
    public MyBooksRoute(String name) {
        super(name);
    }

    @Override
    public void process(HashMap<String, Object> screenParams) {
    }

    @Override
    public void process() {
        ArrayList<Book> bookRows = null;
        try {
            bookRows = DbReader.readFromBooks("username", SessionManager.session.get("username"));
        } catch (SQLException | InvalidInputException ex){
            System.out.println(ex.getMessage());
            renderErrorScreen("Error when retrieving books from database.");
            ex.printStackTrace();
        }
        elements.put("user_id", SessionManager.session.get("user_id"));
        elements.put("book_rows", bookRows);
        elements.put("index", 0);
        renderScreen("my_books", elements);
    }
}
