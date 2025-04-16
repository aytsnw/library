package com.aytsnw.model;

import com.aytsnw.devices.Validator;
import com.aytsnw.exceptions.InvalidInputException;

public class Book {
    private String title;
    private String author;
    private Long isbn;
    private String publisher;
    private Integer year;
    private String category;


    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public Long getIsbn() {return isbn;}
    public String getPublisher() {return publisher;}
    public Integer getYear() {return year;}
    public String getCategory() {return category;}

    public void setTitle(String title) {
        try{
            Validator.validateTitle(title);
            this.title = title;
        } catch (InvalidInputException ex){System.out.println(ex.getMessage());}
    }

    public void setAuthor(String author) {
        try{
            Validator.validateAuthor(author);
            this.author = author;
        } catch (InvalidInputException ex){System.out.println(ex.getMessage());}
    }

    public void setIsbn(String isbn) {
        try{
            this.isbn = Validator.validateIsbn(isbn);
        } catch (InvalidInputException ex){System.out.println(ex.getMessage());}
    }

    public void setPublisher(String publisher) {
        try{
            Validator.validatePublisher(publisher);
            this.publisher = publisher;
        } catch (InvalidInputException ex){System.out.println(ex.getMessage());}
    }

    public void setYear(String year) {
        try{
            this.year = Validator.validateYear(year);
        } catch (InvalidInputException ex){System.out.println(ex.getMessage());}
    }

    public void setCategory(String category) {
        try{
            Validator.validateCategory(category);
            this.category = category;
        } catch (InvalidInputException ex){System.out.println(ex.getMessage());}
    }
}
