package com.aytsnw.ui.logreg;

import com.aytsnw.core.Screen;
import com.aytsnw.windows.RootWindow;

import java.util.HashMap;

public class UserRegisteredScreen extends Screen {
    public UserRegisteredScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        createLabel((String) routeParams.get("message"));
        bindRoute("login", createButton("Login"));
    }

    @Override
    public void display() {}

    @Override
    public void display(String message) {}
}
