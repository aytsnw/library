package com.aytsnw.ui;

import com.aytsnw.core.Screen;
import com.aytsnw.devices.Alternator;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AddBookScreen extends Screen {
    HashMap<String, String> fields = null;
    HashMap<String, JTextField> entries = new HashMap<>();

    public AddBookScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        Object obj = routeParams.get("fields");

        try{
            fields = (HashMap<String, String>) obj;
        } catch (ClassCastException ex){
            System.out.println("'fields' elements must be of type: 'String'.");
            System.out.println(ex.getMessage());
            return;
        }

        JTextField title = createField("title", 20);
        entries.put("title", title);

        JTextField author = createField("author", 20);
        entries.put("author", author);

        JTextField isbn = createField("isbn", 20);
        entries.put("isbn", isbn);

        JTextField publisher = createField("publisher", 20);
        entries.put("publisher", publisher);

        JTextField year = createField("year", 20);
        entries.put("year", year);

        JTextField category = createField("category", 20);
        entries.put("category", category);

        JButton submitBtn = new JButton();
        this.parent.add(submitBtn);
        bindAction("add", submitBtn);
    }

    private JTextField createField(String fieldKey, int width){
        JLabel label = new JLabel(fields.get(fieldKey));
        JTextField entry = new JTextField(width);
        this.parent.add(entry);
        this.parent.add(label);
        return entry;
    }

     private void bindAction(String routeName, JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, Object> values = new HashMap<>();
                values.put("title", entries.get("title").getText());
                values.put("author", entries.get("author").getText());
                values.put("isbn", entries.get("isbn").getText());
                values.put("publisher", entries.get("publisher").getText());
                values.put("year", entries.get("year").getText());
                values.put("category", entries.get("category").getText());
                Alternator.alternateRoute(routeName, values);
            }
        });
    }

    @Override
    public void display() {

    }
}
