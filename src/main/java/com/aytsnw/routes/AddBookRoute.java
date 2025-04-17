package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbWriter;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.model.Book;

import java.sql.SQLException;
import java.util.HashMap;

public class AddBookRoute extends Route {
    public AddBookRoute(String name) {
        super(name);
    }

    @Override
    public void process(HashMap<String, Object> screenParams) {
        String message = null;

        try{
            DbWriter.writeToBooks(parseBook(screenParams));
            message = "Book added to database!";
        } catch (InvalidInputException ex){
            message = "Couldn't add book to database: " + ex.getMessage();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        elements.put("message", message);

        renderScreen("book_added", elements);
    }

    private Book parseBook(HashMap<String, Object> screenParams) throws InvalidInputException{
        Book book = new Book();
        book.setTitle((String) screenParams.get("title"));
        book.setAuthor((String) screenParams.get("author"));
        book.setIsbn((String) screenParams.get("isbn"));
        book.setPublisher((String) screenParams.get("publisher"));
        book.setYear((String) screenParams.get("year"));
        book.setCategory((String) screenParams.get("category"));
        return book;
    }

    @Override
    public void process() {renderScreen("add_book", elements);}
}
