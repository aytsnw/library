package com.aytsnw.ui.bookcrud;

import com.aytsnw.core.Screen;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public class BookAddedScreen extends Screen {
    public BookAddedScreen(String name, String title, JPanel rootFrame) {
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        JLabel messageLabel = new JLabel((String) routeParams.get("message"));
        addToParent(messageLabel);
    }

    @Override
    public void display() {}

    @Override
    public void display(String message) {}
}
