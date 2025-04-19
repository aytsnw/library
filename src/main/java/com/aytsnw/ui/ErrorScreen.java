package com.aytsnw.ui;

import com.aytsnw.core.Screen;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.util.HashMap;

public class ErrorScreen extends Screen {
    public ErrorScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {}

    @Override
    public void display(String message) {
        drawHeader();
        createLabel(message);
    }

    @Override
    public void display() {}
}
