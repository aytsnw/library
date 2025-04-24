package com.aytsnw.devices;

import com.aytsnw.exceptions.InvalidInputException;

import java.util.HashMap;

public class BookValidator {

    public static void validateTitle(String title) throws InvalidInputException{
        if (title.isEmpty()){throw new InvalidInputException("Empty title!");}
    }

    public static void validateAuthor(String author) throws InvalidInputException{
        if (author.isEmpty()){throw new InvalidInputException("Empty author!");}
    }

    public static Long validateIsbn(String isbn) throws InvalidInputException{
        if (isbn.isEmpty()){throw new InvalidInputException("Empty ISBN!");}
        else if (isbn.length() != 13 ){throw new InvalidInputException("Invalid ISBN! (It must contain 13 digits)");}
        else {
            try{return Long.parseLong(isbn);}
            catch (NumberFormatException ex){throw new InvalidInputException("Invalid ISBN!");}
        }
    }

    public static void validatePublisher(String publisher) throws InvalidInputException{
        if (publisher.isEmpty()){throw new InvalidInputException("Empty publisher!");}
    }

    public static Integer validateYear(String year) throws InvalidInputException{
        if (year.isEmpty()){throw new InvalidInputException("Empty year!");}
        else if (year.length() != 4) {throw new InvalidInputException("Invalid year of publication!");}
        else {
            try {
                return Integer.parseInt(year);
            } catch (NumberFormatException ex){
                throw new InvalidInputException("Invalid year of publication!");
            }
        }
    }

    public static void validateCategory(String cat) throws InvalidInputException{
        if (cat.isEmpty()){throw new InvalidInputException("Empty category!");}
    }

    public static Long parseIsbn(String isbn){return Long.parseLong(isbn);}

    public static Integer parseYear(String year){return Integer.parseInt(year);}
}
