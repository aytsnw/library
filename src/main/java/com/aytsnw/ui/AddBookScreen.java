package com.aytsnw.ui;

import javax.swing.*;
import java.util.HashMap;

public class AddBookScreen extends Screen{
    public AddBookScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> params) {
        drawHeader();

        JLabel titleLabel = new JLabel("Title");
        JTextField titleEntry = new JTextField(20);
        this.parent.add(titleLabel);
        this.parent.add(titleEntry);

        JLabel authorLabel = new JLabel("Author");
        JTextField authorEntry = new JTextField(20);
        this.parent.add(authorLabel);
        this.parent.add(authorEntry);

        JLabel isbnLabel = new JLabel("ISBN");
        JTextField isbnEntry = new JTextField(20);
        this.parent.add(isbnLabel);
        this.parent.add(isbnEntry);

        JLabel yearLabel = new JLabel("Publication year");
        JTextField yearEntry = new JTextField(20);
        this.parent.add(yearLabel);
        this.parent.add(yearEntry);

        JLabel categoryLabel = new JLabel("Category");
        JTextField categoryEntry = new JTextField(20);
        this.parent.add(categoryLabel);
        this.parent.add(categoryEntry);
    }

    @Override
    public void display() {

    }
}
