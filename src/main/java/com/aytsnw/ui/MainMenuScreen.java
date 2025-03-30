package com.aytsnw.ui;

import com.aytsnw.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainMenuScreen extends Screen{

    static ArrayList<String> options = new ArrayList<>();
    Scanner scan;

    public MainMenuScreen(String name, Integer code){
        super(name, code);
        scan = new Scanner(System.in);
    }

    private void initMap(){
        options.add("Add book");
        options.add("Remove book");
        options.add("Borrow book");
        options.add("Return book");
    }

    @Override
    public void display(){
        initMap();
        mainLoop();
    }

    private void mainLoop(){
        while (true){
            drawHeader();
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

    @Override
    void drawHeader(){
        drawEdge();
        System.out.print("--- Main Menu ---");
        System.out.println("\n");
    }

    private void displayOptions(){
        int index = 1;
        for (String option : options){
            System.out.println(index + ". " + option);
            index++;
        }
        System.out.println();
        System.out.print("0. Exit");
    }
}
