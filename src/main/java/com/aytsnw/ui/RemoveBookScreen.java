package com.aytsnw.ui;

import com.aytsnw.db.DbReader;
import com.aytsnw.exceptions.InvalidInputException;

import java.util.Scanner;

public class RemoveBookScreen extends Screen{
    Scanner scan;

    public RemoveBookScreen(String name, String title, Integer code){
        super(name, title, code);
        scan = new Scanner(System.in);
    }

    @Override
    void fillOptions(){
        options.add("Select by title");
        options.add("Select by ISBN");
    }

    @Override
    public void display() {
        drawHeader();
        mainLoop();
    }

    private void mainLoop(){
        displayOptions();
    }
}
