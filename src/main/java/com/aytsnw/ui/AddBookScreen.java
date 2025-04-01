package com.aytsnw.ui;

import com.aytsnw.db.DbWriter;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.HashMap;

public class AddBookScreen extends Screen{
    Scanner scan;
    HashMap<String, Object> columns = new HashMap<>();

    public AddBookScreen(String name, Integer code){
        super(name, code);
        scan = new Scanner(System.in);
    }

    @Override
    public void display() {
        drawHeader();
        mainLoop();
    }

    private void mainLoop(){
        while(true){
            System.out.print("Title: ");
            String title = scan.nextLine();
            columns.put("title", title);
            System.out.print("Author: ");
            String author = scan.nextLine();
            columns.put("author", author);
            System.out.print("ISBN: ");
            Integer isbn = null;
            try {
                isbn = Integer.parseInt(scan.nextLine());
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
            } catch (SQLException ex){
                System.out.println("SQL Error: Failed writing to table books.");
                System.out.println(ex.getMessage());
                callDecisionMenu();
            }
            return;
        }
    }

    private void writeToDB(HashMap<String, Object> columns) throws SQLException {
        DbWriter.writeToBooks(columns);
    }

    @Override
    void drawHeader(){
        System.out.println();
        drawEdge();
        System.out.print("--- Add book ---");
        System.out.println("\n");
    }

    private void callDecisionMenu(){
        ScreenAlternator.alternateScreen(ScreenAlternator.screens.get(-1));
    }
}
