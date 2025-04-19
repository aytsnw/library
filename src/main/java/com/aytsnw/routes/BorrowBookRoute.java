package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbWriter;
import com.aytsnw.devices.ScreenDisplayer;

import java.sql.SQLException;
import java.util.HashMap;

public class BorrowBookRoute extends Route {

    public BorrowBookRoute(String name) {
        super(name);
    }

    @Override
    public void process(HashMap<String, Object> screenParams) {
        String id = (String) screenParams.get("id");
        try{
            DbWriter.updateLoanStatus(id, "borrow");
        } catch (SQLException ex){
            System.out.println("SQL Error: Couldn't execute loan.");
            System.out.println(ex.getMessage());
            renderErrorScreen("Failed to borrow book.");
            return;
        }

        elements.put("message", "Book borrowed!");
        renderScreen("book_borrowed", elements);
    }

    @Override
    public void process() {}
}
