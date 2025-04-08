package com.aytsnw.core;

import com.aytsnw.devices.Alternator;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract  class Screen {
    public static HashMap<String, Screen> screens = new HashMap<>();

    private String name;
    protected RootWindow parent;
    private String title;

    public Screen(String name, String title, RootWindow root){
        this.name = name;
        this.title = title;
        this.parent = root;
        screens.put(name, this);
    }

    public void drawHeader(){
        JLabel header = new JLabel(this.title);
        drawNavBar();
        parent.add(header);
    }

    private void drawNavBar(){
        createButton("Main Menu", "index");
        createButton("Return", "prev");
    }

    JButton createButton(String text, String routeName){
        JButton btn = new JButton(text);
        bindRoute(routeName, btn);
        this.parent.add(btn);
        return btn;
    }

    private void bindRoute(String routeName, JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(routeName.equals("prev"))) Alternator.alternateRoute(routeName);
                else Alternator.alternatePrev();
            }
        });
    }

    public abstract void display(HashMap<String, Object> routeParams);
    public abstract void display();
}
