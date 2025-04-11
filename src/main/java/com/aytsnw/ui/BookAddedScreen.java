package com.aytsnw.ui;

import com.aytsnw.core.Screen;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.util.HashMap;

public class BookAddedScreen extends Screen {
    public BookAddedScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        JLabel messageLabel = new JLabel((String) routeParams.get("message"));
        this.parent.add(messageLabel);
    }

    @Override
    public void display() {

    }
}
