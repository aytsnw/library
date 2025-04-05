package com.aytsnw.ui;

import com.aytsnw.exceptions.InvalidInputException;

import java.util.Scanner;

public class DecisionMenuScreen extends Screen{
    Scanner scan = new Scanner(System.in);

    public DecisionMenuScreen(String name, String title, Integer code) {
        super(name, title, code);
    }

    @Override
    void fillOptions(){
        options.add("Continue");
        options.add("Return to Main Menu");
    }

    @Override
    public void display() {
        drawHeader();
        displayOptions();
        int choice;
        try{
            choice = Integer.parseInt(scan.nextLine());
            System.out.println("Your choice: " + choice);
            validateChoice(choice, 1, getOptionsSize());
        } catch (NumberFormatException | InvalidInputException ex){
            System.out.println("Invalid choice!");
            refresh();
            return;
        }
        if (choice == 1){
            ScreenAlternator.alternateScreen(ScreenAlternator.prevScreen);
        } else {
            ScreenAlternator.alternateScreen(ScreenAlternator.screens.get(5));
        }
    }
}
