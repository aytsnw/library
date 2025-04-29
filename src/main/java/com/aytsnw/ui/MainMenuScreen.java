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
        createLabel("Welcome, " + routeParams.get("username") + ".");
        if (SessionManager.session.get("level").equals("librarian")) bindRouteToButton("add_book", createButton("Add Book"));
        bindRouteToButton("my_books", createButton("My Books"));
        bindRouteToButton("search_book", createButton("Search Book"));
        bindRouteToButton("logout", createButton("Logout"));
    }

    @Override
    public void display() {drawHeader();}

    @Override
    public void display(String message) {}
}
