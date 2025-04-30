package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbWriter;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.models.Transaction;

import java.sql.SQLException;
import java.util.HashMap;

public class ReturnBookRoute extends Route {

    public ReturnBookRoute(String name) {
        super(name);
    }

    @Override
    public void process(HashMap<String, Object> screenParams) {
        Transaction tran = new Transaction();
        tran.setType("return");
        tran.setUserId(Integer.parseInt(screenParams.get("user_id").toString()));
        tran.setBookId(Integer.parseInt(screenParams.get("book_id").toString()));
        try{
            DbWriter.updateBookStatus(tran);
        } catch (SQLException | InvalidInputException ex){
            System.out.println("SQL Error: Couldn't execute return.");
            System.out.println(ex.getMessage());
            renderErrorScreen("Failed to return book, try again.");
            ex.printStackTrace();
            return;
        }

        elements.put("message", "Book returned to Library!");
        renderScreen("book_returned", elements);
    }

    @Override
    public void process() {}
}
