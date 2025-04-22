package com.aytsnw.core;

import com.aytsnw.devices.Alternator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract  class Screen {
    public static HashMap<String, Screen> screens = new HashMap<>();

    protected HashMap<String, Object> elements = new HashMap<>();

    private String name;
    protected JPanel rootFrame;
    protected String title;

    protected Screen(String name, String title, JPanel rootFrame){
        this.name = name;
        this.title = title;
        this.rootFrame = rootFrame;
        screens.put(name, this);
    }

    protected void addToParent(Component component){
        this.rootFrame.add(component);
    }

    protected JButton createButton(String text){
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(20, 20));
        addToParent(btn);
        return btn;
    }

    protected void bindRouteToButton(String routeName, JButton btn){
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

    protected void bindRouteToButton(String routeName, JButton btn, HashMap<String, Object> params){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(routeName.equals("prev"))) Alternator.alternateRoute(routeName, params);
                else Alternator.alternatePrev();
            }
        });
    }

    protected void drawNavBar(){
        bindRouteToButton("index", createButton("Main Menu"));
        bindRouteToButton("prev", createButton("Return"));
    }

    protected void drawHeader(){
        drawNavBar();
        JLabel l = createLabel(this.title);
        l.setFont(new Font("Arial", Font.BOLD, 22));
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        l.setHorizontalAlignment(SwingConstants.CENTER);
    }

    protected JLabel createLabel(String labelText){
        JLabel label = new JLabel(labelText);
        addToParent(label);
        return label;
    }

    protected JTextField createField(String fieldName, int width){
        createLabel(fieldName);
        JTextField entry = new JTextField(width);
        entry.setMaximumSize(entry.getPreferredSize());
        addToParent(entry);
        return entry;
    }

    public abstract void display(HashMap<String, Object> routeParams);
    public abstract void display();
    public abstract void display(String message);
}
