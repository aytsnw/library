package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbWriter;
import com.aytsnw.devices.ScreenDisplayer;
import com.aytsnw.exceptions.InvalidInputException;

import java.sql.SQLException;
import java.util.HashMap;

public class ReturnBookRoute extends Route {

    public ReturnBookRoute(String name) {
        super(name);
    }

    @Override
    public void process(HashMap<String, Object> screenParams) {
        try{
            DbWriter.updateLoanStatus(screenParams.get("user_id").toString(), screenParams.get("book_id").toString(), "return");
        } catch (SQLException | InvalidInputException ex){
            System.out.println("SQL Error: Couldn't execute return.");
            System.out.println(ex.getMessage());
            renderErrorScreen("Failed to return book, try again.");
            return;
        }

        elements.put("message", "Book returned to Library!");
        renderScreen("book_returned", elements);
    }

    @Override
    public void process() {}
}
