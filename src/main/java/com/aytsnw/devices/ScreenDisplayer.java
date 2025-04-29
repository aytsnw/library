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
        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        double monitorWidth = monitorSize.getWidth();
        double monitorHeight = monitorSize.getHeight();
        int windowWidth = 420;
        int windowHeight = 570;
        rootWindow.setLocation((int) (monitorWidth/2) - windowWidth/2, (int) (monitorHeight/2) - windowHeight/2);
        rootWindow.setSize(windowWidth, windowHeight);
        rootWindow.setDefaultCloseOperation(RootWindow.EXIT_ON_CLOSE);
        rootWindow.setLayout(new FlowLayout());
        rootWindow.setIconImage(new ImageIcon("resources/icon/icon.png").getImage());
        rootWindow.getContentPane().setBackground(new Color(102, 51, 0));
        rootWindow.setVisible(true);
        rootWindow.setInitState(true);
    }

    public static void initRootFrame(){
        rootFrame.setLayout(new GridLayout(0, 1));
        rootFrame.setBackground(new Color(102, 51, 0));
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
        if (Screen.screens.get("error") == null) {System.out.println("Screen '" + "error" + "' not initialized."); return;}
        Screen.screens.get("error").display(message);
        rootFrame.revalidate();
        rootFrame.repaint();
    }
}

