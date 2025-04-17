package com.aytsnw.ui;

import com.aytsnw.core.Screen;
import com.aytsnw.devices.Alternator;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class MainMenuScreen extends Screen {

    public MainMenuScreen(String name, String title, RootWindow root){
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        JButton addBtn = createButton("Add Book");
        bindRoute("add_book", addBtn);
        JButton searchBtn = createButton("Search Book");
        bindRoute("search_book", searchBtn);
        JButton exitBtn = createButton("Exit");
        bindRoute("exit", exitBtn);
    }

    @Override
    public void display() {drawHeader();}
}
