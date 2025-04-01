package com.aytsnw.ui;

import com.aytsnw.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainMenuScreen extends Screen{

    ArrayList<String> options = new ArrayList<>();
    int optionsSize;
    Scanner scan;

    public MainMenuScreen(String name, Integer code){
        super(name, code);
        scan = new Scanner(System.in);
        initMap();
    }

    private void initMap(){
        options.add("Add book");
        options.add("Remove book");
        options.add("Borrow book");
        options.add("Return book");
        optionsSize = options.size();
    }

    @Override
    public void display(){
        mainLoop();
    }

    private int getOptionsSize(){return optionsSize;}

    private void validateChoice(int choice) throws InvalidInputException {
        if (choice < 0 || choice > getOptionsSize()){
            throw new InvalidInputException();
        }
    }

    int getChoice(Scanner scan) throws InvalidInputException{
        try {
            int choice = scan.nextInt();
            validateChoice(choice);
            scan.nextLine();
            return choice;
        } catch (NoSuchElementException | InvalidInputException ex) {
            scan.nextLine();
            throw new InvalidInputException("Invalid input. You must type a valid option.");
        }
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
        System.out.println();
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
