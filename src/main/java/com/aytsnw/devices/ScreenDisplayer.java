package com.aytsnw.devices;

import com.aytsnw.windows.RootWindow;
import com.aytsnw.core.Screen;

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
        try{
            Screen.screens.get(screenName).display(params);
        } catch (NullPointerException ex){
            System.out.println("Screen '" + screenName + "' not initialized.");
        }
        parent.revalidate();
        parent.repaint();
    }

    public static void displayScreen(String screenName){
        parent.getContentPane().removeAll();
        try {
            Screen.screens.get(screenName).display();
        } catch (NullPointerException ex){
            System.out.println("Screen '" + screenName + "' not initialized.");
        }
        parent.revalidate();
        parent.repaint();
    }

    public static void displayErrorScreen(String message){
        parent.getContentPane().removeAll();
        try {
            Screen.screens.get("error").display(message);
        } catch (NullPointerException ex){
            System.out.println("Screen '" + "error" + "' not initialized.");
        }
        parent.revalidate();
        parent.repaint();
    }
}

