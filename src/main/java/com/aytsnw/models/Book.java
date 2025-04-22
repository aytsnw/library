package com.aytsnw.models;

import com.aytsnw.devices.BookValidator;
import com.aytsnw.exceptions.InvalidInputException;

public class Book {
    private String title;
    private String author;
    private Long isbn;
    private String publisher;
    private Integer year;
    private String category;
    private String loan_status;


    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public Long getIsbn() {return isbn;}
    public String getPublisher() {return publisher;}
    public Integer getYear() {return year;}
    public String getCategory() {return category;}

    public void setTitle(String title) throws InvalidInputException{
        BookValidator.validateTitle(title);
        this.title = title;
    }

    public void setAuthor(String author) throws InvalidInputException{
        BookValidator.validateAuthor(author);
        this.author = author;
    }

    public void setIsbn(String isbn) throws InvalidInputException{
        this.isbn = BookValidator.validateIsbn(isbn);
    }

    public void setPublisher(String publisher) throws InvalidInputException{
        BookValidator.validatePublisher(publisher);
        this.publisher = publisher;
    }

    public void setYear(String year) throws InvalidInputException{
        this.year = BookValidator.validateYear(year);
    }

    public void setCategory(String category) throws InvalidInputException{
        BookValidator.validateCategory(category);
        this.category = category;
    }
}
