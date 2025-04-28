package com.aytsnw.ui.bookcrud;

import com.aytsnw.core.Screen;

import javax.swing.*;
import java.util.HashMap;

public class BookReturnedScreen extends Screen {
    public BookReturnedScreen(String name, String title, JPanel rootFrame) {
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        JLabel label = new JLabel((String) routeParams.get("message"));
        addToParent(label);
    }

    @Override
    public void display() {}

    @Override
    public void display(String message) {}
}
