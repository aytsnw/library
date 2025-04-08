package com.aytsnw.core;


import javax.swing.*;


public abstract class Window extends JFrame {
    private boolean initState = false;

    public Window(String name){
        super(name);
    }

    public void setInitState(boolean state){
        initState = state;
    }

    public boolean getInitState(){
        return initState;
    }
}
