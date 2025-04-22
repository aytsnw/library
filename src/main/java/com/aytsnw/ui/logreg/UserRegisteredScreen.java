package com.aytsnw.ui.logreg;

import com.aytsnw.core.Screen;

import javax.swing.*;
import java.util.HashMap;

public class UserRegisteredScreen extends Screen {
    public UserRegisteredScreen(String name, String title, JPanel rootFrame) {
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        createLabel((String) routeParams.get("message"));
        bindRouteToButton("login", createButton("Login"));
    }

    @Override
    public void display() {}

    @Override
    public void display(String message) {}
}
