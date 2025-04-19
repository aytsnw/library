package com.aytsnw.ui.bookcrud;

import com.aytsnw.core.Screen;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.util.HashMap;

public class BookBorrowedScreen extends Screen {
    public BookBorrowedScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        addToParent(new JLabel((String) routeParams.get("message")));
    }

    @Override
    public void display() {}

    @Override
    public void display(String message) {}
}
