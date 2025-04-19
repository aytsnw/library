package com.aytsnw.core;

import com.aytsnw.devices.Alternator;
import com.aytsnw.devices.ScreenDisplayer;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract  class Screen {
    public static HashMap<String, Screen> screens = new HashMap<>();

    protected HashMap<String, Object> elements = new HashMap<>();

    private String name;
    protected RootWindow parent;
    protected String title;

    protected Screen(String name, String title, RootWindow root){
        this.name = name;
        this.title = title;
        this.parent = root;
        screens.put(name, this);
    }
    protected void drawNavBar(){
        JButton mainBtn = createButton("Main Menu");
        bindRoute("index", mainBtn);
        JButton returnBtn = createButton("Return");
        bindRoute("prev", returnBtn);
    }

    protected JButton createButton(String text){
        JButton btn = new JButton(text);
        this.parent.add(btn);
        return btn;
    }

    protected void drawHeader(){
        JLabel header = new JLabel(this.title);
        drawNavBar();
        parent.add(header);
    }

    protected JLabel createLabel(String labelText){
        JLabel label = new JLabel(labelText);
        addToParent(label);
        return label;
    }

    protected void bindRoute(String routeName, JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(routeName.equals("prev"))) {
                    System.out.println("Calling via route name");
                    Alternator.alternateRoute(routeName);}
                else {
                    System.out.println("Calling via alternate prev");
                    Alternator.alternatePrev();
                }
            }
        });
    }

    protected void bindRoute(String routeName, JButton btn, HashMap<String, Object> params){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(routeName.equals("prev"))) Alternator.alternateRoute(routeName, params);
                else Alternator.alternatePrev();
            }
        });
    }

    protected void addToParent(Component component){
        this.parent.add(component);
    }

    protected JTextField createField(String fieldName, int width){
        JLabel label = new JLabel(fieldName);
        JTextField entry = new JTextField(width);
        addToParent(entry);
        addToParent(label);
        return entry;
    }

    public abstract void display(HashMap<String, Object> routeParams);
    public abstract void display();
    public abstract void display(String message);
}
