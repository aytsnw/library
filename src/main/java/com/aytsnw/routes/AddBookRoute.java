package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbWriter;
import com.aytsnw.devices.ScreenDisplayer;
import com.aytsnw.devices.Validator;
import com.aytsnw.exceptions.InvalidInputException;

import java.sql.SQLException;
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
    protected void init() {fillFields(); elements.put("fields", fields);}

    @Override
    public void process(HashMap<String, Object> screenParams) {
        init();
        String message = null;

        try{
            Validator.validate(screenParams);
            DbWriter.writeToBooks(screenParams);
            message = "Book added to database!";
        } catch (InvalidInputException | SQLException | NullPointerException ex){
            message = ex.getMessage();
        }

        elements.put("message", message);

        renderScreen("book_added", elements);
    }

    @Override
    public void process() {init();renderScreen("add", elements);}
}
