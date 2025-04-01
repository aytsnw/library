package com.aytsnw.ui;

import com.aytsnw.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class Screen {

    public String name;
    public Integer screenCode;

    public Screen(String name, Integer code){
        this.name = name;
        this.screenCode = code;
    }

    void drawEdge(){
        System.out.println("---------------------------------------");
    }

    void refresh(){
        ScreenAlternator.alternateScreen(ScreenAlternator.currentScreen);
    }

    abstract void drawHeader();

    public abstract void display();
}
