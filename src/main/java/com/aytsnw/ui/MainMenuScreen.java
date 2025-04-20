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

    public MainMenuScreen(String name, String title, JPanel rootFrame){
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        bindRoute("add_book", createButton("Add Book"));
        bindRoute("search_book", createButton("Search Book"));
        bindRoute("exit", createButton("Exit"));
    }

    @Override
    public void display() {drawHeader();}

    @Override
    public void display(String message) {}
}
