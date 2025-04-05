package com.aytsnw.ui;

import com.aytsnw.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class Screen {

    public String name;
    public String title;
    public Integer screenCode;

    ArrayList<String> options = new ArrayList<>();
    int optionsSize;

    public Screen(String name, String title, Integer code){
        this.name = name;
        this.screenCode = code;
        this.title = title;
        fillOptions();
    }

    int getOptionsSize(){return optionsSize;}

    short getChoice(Scanner scan) throws InvalidInputException{
        try {
            short choice = Short.parseShort(scan.nextLine());
            validateChoice(choice, 0, getOptionsSize());
            return choice;
        } catch (NoSuchElementException | InvalidInputException ex) {
            throw new InvalidInputException("Invalid input. You must type a valid option.");
        }
    }

    abstract void fillOptions();

    private void drawEdge(){
        System.out.println("---------------------------------------");
    }

    void refresh(){
        ScreenAlternator.alternateScreen(ScreenAlternator.currentScreen);
    }

    void drawHeader(){
        drawEdge();
        System.out.println("----- " + this.title + " -----");
    }

    void displayOptions(){
        int index = 1;
        for (String option : options){
            System.out.println(index + ". " + option);
            index++;
        }
        System.out.println();
        System.out.print("0. Exit");
    }

    void validateChoice(int choice, int min, int max) throws InvalidInputException {
        if (choice < min|| choice > max){
            throw new InvalidInputException();
        }
    }

    void callDecisionMenu(){
        ScreenAlternator.alternateScreen(ScreenAlternator.screens.get(-1));
    }

    public abstract void display();
}
