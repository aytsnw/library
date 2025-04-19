package com.aytsnw.ui.search;

import com.aytsnw.core.Screen;
import com.aytsnw.devices.Alternator;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class SearchScreen extends Screen {

    public SearchScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
    }

    @Override
    public void display() {
        drawHeader();
        JTextField titleEntry = new JTextField(20);
        addToParent(titleEntry);
        JButton searchTitleBtn = createButton("Search by Title");
        bindFormSubmitting("title", "search_book", searchTitleBtn, titleEntry);

        JTextField isbnEntry = new JTextField(20);
        addToParent(isbnEntry);
        JButton searchIsbn = createButton("Search by ISBN");
        bindFormSubmitting("isbn", "search_book", searchIsbn, isbnEntry);
    }

    @Override
    public void display(String message) {

    }

    void bindFormSubmitting(String type, String routeName, JButton btn, JTextField entry){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elements.put("type", type);
                elements.put("entry", entry.getText());
                Alternator.alternateRoute(routeName, elements);
            }
        });
    }
}
