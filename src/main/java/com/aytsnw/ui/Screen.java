package com.aytsnw.ui;

import javax.swing.*;
import java.util.HashMap;

public abstract  class Screen {
    static HashMap<String, Screen> screens = new HashMap<>();

    private String name;
    RootWindow parent;
    private String title;

    public Screen(String name, String title, RootWindow root){
        this.name = name;
        this.title = title;
        this.parent = root;
        screens.put(name, this);
    }

    public void drawHeader(){
        JLabel header = new JLabel(this.title);
        parent.add(header);
    }

    public abstract void display(HashMap<String, Object> params);
    public abstract void display();
}
