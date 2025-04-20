package com.aytsnw.ui;

import com.aytsnw.core.Screen;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public class ErrorScreen extends Screen {
    public ErrorScreen(String name, String title, JPanel rootFrame) {
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {}

    @Override
    public void display(String message) {
        drawHeader();
        createLabel(message);
    }

    @Override
    protected void drawHeader(){
        bindRoute("prev", createButton("Return"));
        JLabel l = createLabel(this.title);
        l.setFont(new Font("Arial", Font.BOLD, 24));
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setBorder(new EmptyBorder(10, 20, 10, 20));
    }

    @Override
    public void display() {}
}
