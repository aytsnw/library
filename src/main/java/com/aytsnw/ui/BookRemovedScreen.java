package com.aytsnw.ui;

import com.aytsnw.core.Screen;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.util.HashMap;

public class BookRemovedScreen extends Screen {
    public BookRemovedScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        JLabel label = new JLabel((String) routeParams.get("message"));
        addToParent(label);
    }

    @Override
    public void display() {

    }
}
