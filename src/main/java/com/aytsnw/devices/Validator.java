package com.aytsnw.devices;

import com.aytsnw.exceptions.InvalidInputException;

import java.util.HashMap;

public class Validator {
    public static void validate(HashMap<String, Object> columns) throws InvalidInputException, NullPointerException{
            validateTitle( (String) columns.get("title"));
            validateAuthor( (String) columns.get("author"));
            String isbn = (String) columns.get("isbn");
            validateIsbn(isbn);
            columns.replace("isbn", parseIsbn(isbn));
            validatePublisher( (String) columns.get("publisher"));
            String year = (String) columns.get("year");
            validateYear(year);
            columns.replace("year", parseYear(year));
            validateCategory( (String) columns.get("category"));
    }

    private static void validateTitle(String title) throws InvalidInputException{
        if (title.isEmpty()){
            throw new InvalidInputException("Empty title!");
        }
    }

    private static void validateAuthor(String author) throws InvalidInputException{
        if (author.isEmpty()){
            throw new InvalidInputException("Empty author!");
        }
    }

    private static void validateIsbn(String isbn) throws InvalidInputException{
        if (isbn.isEmpty()){
            throw new InvalidInputException("Empty ISBN!");
        } else if (isbn.length() != 13 ){
            throw new InvalidInputException("Invalid ISBN! (It must contain 13 digits)");
        }else {
            try {
                Long isbnLong = Long.parseLong(isbn);
            } catch (NumberFormatException ex){
                throw new InvalidInputException("Invalid ISBN!");
            }
        }
    }

    private static void validatePublisher(String publisher) throws InvalidInputException{
        if (publisher.isEmpty()){
            throw new InvalidInputException("Empty publisher!");
        }
    }

    private static void validateYear(String year) throws InvalidInputException{
        if (year.isEmpty()){
            throw new InvalidInputException("Empty title!");
        } else if (year.length() != 4) {
            throw new InvalidInputException("Invalid year of publication!");
        }
    }

    private static void validateCategory(String cat) throws InvalidInputException{
        if (cat.isEmpty()){
            throw new InvalidInputException("Empty category!");
        }
    }

    public static Long parseIsbn(String isbn){
        return Long.parseLong(isbn);
    }

    public static Integer parseYear(String year){
        return Integer.parseInt(year);
    }
}
