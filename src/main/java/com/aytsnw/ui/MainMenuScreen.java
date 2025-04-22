package com.aytsnw.ui;

import com.aytsnw.core.Screen;
import com.aytsnw.session.SessionManager;

import javax.swing.*;
import java.util.HashMap;


public class MainMenuScreen extends Screen {

    public MainMenuScreen(String name, String title, JPanel rootFrame){
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        if (SessionManager.session.get("level").equals("librarian")) bindRouteToButton("add_book", createButton("Add Book"));

        bindRouteToButton("search_book", createButton("Search Book"));
        bindRouteToButton("exit", createButton("Exit"));
    }

    @Override
    public void display() {drawHeader();}

    @Override
    public void display(String message) {}
}
