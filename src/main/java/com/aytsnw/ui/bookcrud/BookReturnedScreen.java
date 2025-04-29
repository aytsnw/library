package com.aytsnw.ui.bookcrud;

import com.aytsnw.core.Screen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public class BookReturnedScreen extends Screen {
    public BookReturnedScreen(String name, String title, JPanel rootFrame) {
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        createLabel((String) routeParams.get("message"));
    }

    @Override
    public void display() {}

    @Override
    public void display(String message) {}
}
