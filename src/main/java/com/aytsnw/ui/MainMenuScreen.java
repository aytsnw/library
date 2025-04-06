package com.aytsnw.ui;

import com.aytsnw.exceptions.InvalidInputException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainMenuScreen extends Screen{

    Scanner scan;

    public MainMenuScreen(String name, String title, Integer code){
        super(name, title, code);
        scan = new Scanner(System.in);
    }

    @Override
    void fillOptions(){
        options.add("Add book");
        options.add("Remove book");
        options.add("Borrow book");
        options.add("Return book");
    }

    @Override
    public void display(){
        drawHeader();
        mainLoop();
    }

    private void mainLoop(){
        while (true){
            int choice;
            displayOptions();
            try {
                choice = getChoice(scan);
            } catch (InvalidInputException ex){
                System.out.println(ex.getMessage());
                continue;
            }
            ScreenAlternator.alternateScreen(ScreenAlternator.screens.get(choice));
            return;
        }
    }
}
