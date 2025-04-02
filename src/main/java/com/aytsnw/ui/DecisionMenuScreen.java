package com.aytsnw.ui;

import java.util.Scanner;

public class DecisionMenuScreen extends Screen{
    Scanner scan = new Scanner(System.in);

    public DecisionMenuScreen(String name, Integer code) {
        super(name, code);
    }

    @Override
    void drawHeader() {
        System.out.println();
        drawEdge();
        System.out.println("--- Do you wish to continue operation? ---");
    }

    @Override
    public void display() {
        drawHeader();
        System.out.println("1. Continue");
        System.out.println("2. Return to main menu");
        int choice;
        try{
            choice = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException ex){
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
