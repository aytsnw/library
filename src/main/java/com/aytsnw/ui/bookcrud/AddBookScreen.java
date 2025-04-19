package com.aytsnw.ui.bookcrud;

import com.aytsnw.core.Screen;
import com.aytsnw.devices.Alternator;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AddBookScreen extends Screen {
    HashMap<String, JTextField> fields = new HashMap<>();

    public AddBookScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();

        fields.put("title", createField("Title", 20));
        fields.put("author", createField("Author", 20));
        fields.put("isbn", createField("ISBN", 20));
        fields.put("publisher", createField("Publisher", 20));
        fields.put("year", createField("Year", 20));
        fields.put("category", createField("Category", 20));

        JButton submitBtn = new JButton();
        addToParent(submitBtn);
        bindAction("add_book", submitBtn);
    }

     private void bindAction(String routeName, JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elements.put("title", fields.get("title").getText());
                elements.put("author", fields.get("author").getText());
                elements.put("isbn", fields.get("isbn").getText());
                elements.put("publisher", fields.get("publisher").getText());
                elements.put("year", fields.get("year").getText());
                elements.put("category", fields.get("category").getText());
                Alternator.alternateRoute(routeName, elements);
            }
        });
    }

    @Override
    public void display() {}

    @Override
    public void display(String message) {}
}
