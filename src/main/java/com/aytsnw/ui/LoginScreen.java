package com.aytsnw.ui;

import com.aytsnw.core.Screen;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.util.HashMap;

public class LoginScreen extends Screen {
    HashMap<String, JTextField> fields = new HashMap<>();

    public LoginScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {}

    @Override
    public void display() {
        drawLoginForm();
    }

    private void drawLoginForm(){
        JTextField username = createField("Username", 20);
        addToParent(username);
        fields.put("username", username);
        JTextField password = createField("Password", 20);
        addToParent(password);
        fields.put("password", password);
    }
}
