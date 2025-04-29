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
        btn.setMinimumSize(new Dimension(50, 20));
        btn.setBackground(new Color(153, 102, 51));
        btn.setForeground(new Color(255, 255, 255));
        addToParent(btn);
        return btn;
    }

    protected void bindRouteToButton(String routeName, JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (routeName.equals("prev")) Alternator.alternatePrev();
                else if (routeName.equals("current")) Alternator.alternateCurrent();
                else Alternator.alternateRoute(routeName);
            }
        });
    }

    protected void bindRouteToButton(String routeName, JButton btn, HashMap<String, Object> params){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (routeName.equals("prev")) Alternator.alternatePrev();
                else if (routeName.equals("current")) Alternator.alternateCurrent();
                else Alternator.alternateRoute(routeName, params);
            }
        });
    }

    protected void drawNavBar(){
        bindRouteToButton("index", createButton("Main Menu"));
        bindRouteToButton("prev", createButton("Return"));
    }

    protected void drawHeader(){
        drawNavBar();
        createLabel("");
        JLabel l = createLabel(this.title);
        l.setFont(new Font("Arial", Font.BOLD, 22));
        createLabel("");
    }

    protected JLabel createLabel(String labelText){
        JLabel label = new JLabel(labelText);
        label.setForeground(new Color(255, 255, 255));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        addToParent(label);
        return label;
    }

    protected JLabel createLabel(String labelText, int fontSize, boolean bold){
        JLabel label = new JLabel(labelText);
        label.setForeground(new Color(255, 255, 255));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        if (bold) label.setFont(new Font("Arial", Font.BOLD, fontSize));
        else label.setFont(new Font("Arial", Font.PLAIN, fontSize));

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

    protected JTextField createPasswordField(String fieldName, int width){
        createLabel(fieldName);
        JTextField entry = new JPasswordField(width);
        entry.setMaximumSize(entry.getPreferredSize());
        addToParent(entry);
        return entry;
    }

    public abstract void display(HashMap<String, Object> routeParams);
    public abstract void display();
    public abstract void display(String message);
}
