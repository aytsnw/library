package com.aytsnw.ui;

import com.aytsnw.core.Screen;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchResultsScreen extends Screen {

    public SearchResultsScreen(String name, String title, RootWindow root) {
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        for (HashMap<String, Object> row : (ArrayList<HashMap<String, Object>>) routeParams.get("rows")){
            createBookFrame(row);
            String id = (String) row.get("id");
            createRemoveBookButton(id);
            createBorrowBookButton(id);
        }
    }

    private void createBookFrame(HashMap<String, Object> elements){
        addToParent(new JLabel((String) elements.get("title")));
        addToParent(new JLabel((String) elements.get("author")));
        addToParent(new JLabel(elements.get("isbn").toString()));
        addToParent(new JLabel((String) elements.get("year")));
        addToParent(new JLabel((String) elements.get("category")));
        addToParent(new JLabel((String) elements.get("loan_status")));
    }

    private void createRemoveBookButton(String id){
        JButton btn = new JButton("Remove from Library");
        elements.put("id", id);
        bindRoute("remove_book", btn, elements);
        addToParent(btn);
    }

    private void createBorrowBookButton(String id){
        JButton btn = new JButton("Borrow book");
        elements.put("id", id);
        bindRoute("borrow_book", btn, elements);
        addToParent(btn);
    }

    @Override
    public void display() {}
}
