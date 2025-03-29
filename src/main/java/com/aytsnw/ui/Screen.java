package com.aytsnw.ui;

public abstract class Screen {

    public String name;
    public Integer screenCode;

    public Screen(String name, Integer code){
        this.name = name;
        this.screenCode = code;
    }

    void drawEdge(){
        System.out.println("------------------------------");
    }

   abstract void drawHeader();

    public abstract void display();
}
