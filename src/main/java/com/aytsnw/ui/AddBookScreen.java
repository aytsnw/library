package com.aytsnw.ui;

import com.aytsnw.db.DbWriter;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.HashMap;

public class AddBookScreen extends Screen{
    Scanner scan;
    HashMap<String, Object> columns = new HashMap<>();

    public AddBookScreen(String name, String title, Integer code){
        super(name, title, code);
        scan = new Scanner(System.in);
    }

    @Override
    void fillOptions() {}

    @Override
    public void display() {
        drawHeader();
        mainLoop();
    }

    @Override
    void displayOptions(){}


    private void mainLoop(){
        System.out.print("Title: ");
        String title = scan.nextLine();
        columns.put("title", title);
        System.out.print("Author: ");
        String author = scan.nextLine();
        columns.put("author", author);
        System.out.print("ISBN: ");
        Long isbn = null;
        try {
            isbn = Long.parseLong(scan.nextLine());
            columns.put("isbn", isbn);
        } catch (NumberFormatException ex){
            System.out.print("Invalid ISBN number!");
            callDecisionMenu();
            return;
        }
        System.out.print("Publisher: ");
        String publisher = scan.nextLine();
        columns.put("publisher", publisher);
        System.out.print("Year published: ");
        Integer year = null;
        try {
            year = Integer.parseInt(scan.nextLine());
            columns.put("year", year);
        } catch (NumberFormatException ex) {
            System.out.print("Invalid year!");
            callDecisionMenu();
        }

        try{
            writeToDB(columns);
            System.out.println("Book added to database!");
            callDecisionMenu();
        } catch (SQLException ex){
            System.out.println("SQL Error: Failed writing to table books.");
            System.out.println(ex.getMessage());
            callDecisionMenu();
        }
    }

    private void writeToDB(HashMap<String, Object> columns) throws SQLException {
        DbWriter.writeToBooks(columns);
    }
}
