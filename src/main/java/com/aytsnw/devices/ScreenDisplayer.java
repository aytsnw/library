package com.aytsnw.devices;

import com.aytsnw.windows.RootWindow;
import com.aytsnw.core.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ScreenDisplayer {
    private static RootWindow rootWindow = new RootWindow("Library");
    private static JPanel rootFrame = new JPanel();

    public static JPanel getRootFrame(){
        return rootFrame;
    }

    public static void initRootWindow(){
        rootWindow.setSize(350, 500);
        rootWindow.setDefaultCloseOperation(RootWindow.EXIT_ON_CLOSE);
        rootWindow.setLayout(new FlowLayout());
        rootWindow.setVisible(true);
        rootWindow.setInitState(true);

        rootFrame.setLayout(new GridLayout(0, 1));
        rootWindow.add(rootFrame);
    }

    public static void displayScreen(String screenName, HashMap<String, Object> params){
        rootFrame.removeAll();
        if (Screen.screens.get(screenName) == null) {System.out.println("Screen '" + screenName + "' not initialized."); return;}
        Screen.screens.get(screenName).display(params);
        rootFrame.revalidate();
        rootFrame.repaint();
    }

    public static void displayScreen(String screenName){
        rootFrame.removeAll();
        if (Screen.screens.get(screenName) == null) {System.out.println("Screen '" + screenName + "' not initialized."); return;}
        Screen.screens.get(screenName).display();
        rootFrame.revalidate();
        rootFrame.repaint();
    }

    public static void displayErrorScreen(String message){
        rootFrame.removeAll();
        try {
            Screen.screens.get("error").display(message);
        } catch (NullPointerException ex){
            System.out.println("Screen '" + "error" + "' not initialized.");
        }
        rootFrame.revalidate();
        rootFrame.repaint();
    }
}

