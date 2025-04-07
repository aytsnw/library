package com.aytsnw.ui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ScreenDisplayer {
    private static RootWindow parent = new RootWindow("Library");

    public static RootWindow getParent(){
        return parent;
    }

    public static void initRootWindow(){
        parent.setSize(400, 400);
        parent.setDefaultCloseOperation(RootWindow.EXIT_ON_CLOSE);
        parent.setLayout(new FlowLayout());
        parent.setVisible(true);
        parent.setInitState(true);
    }

    public static void displayScreen(String screenName, HashMap<String, Object> params){
        parent.getContentPane().removeAll();
        Screen.screens.get(screenName).display(params);
        parent.revalidate();
        parent.repaint();
    }

    public static void displayScreen(String screenName){
        parent.getContentPane().removeAll();
        Screen.screens.get(screenName).display();
        parent.revalidate();
        parent.repaint();
    }
}

