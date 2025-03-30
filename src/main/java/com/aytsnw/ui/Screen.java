package com.aytsnw.ui;

import com.aytsnw.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class Screen {

    public String name;
    public Integer screenCode;
    ArrayList<String> options = new ArrayList<>();

    public Screen(String name, Integer code){
        this.name = name;
        this.screenCode = code;
    }

    void drawEdge(){
        System.out.println("------------------------------");
    }

    private void validateChoice(int choice) throws InvalidInputException {
        if (choice < 0 || choice > options.size()){
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

    abstract void drawHeader();

    public abstract void display();
}
