package com.aytsnw.ui.search;

import com.aytsnw.core.Screen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchResultsScreen extends Screen {

    public SearchResultsScreen(String name, String title, JPanel rootFrame) {
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();

        ArrayList<HashMap<String, Object>> bookRows = (ArrayList<HashMap<String, Object>>) routeParams.get("book_rows");

        if (bookRows == null){
            System.out.println("'book_rows' not passed as argument.");
            return;
        }

        for (HashMap<String, Object> row : bookRows){
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
        bindRouteToButton("remove_book", btn, elements);
        addToParent(btn);
    }

    private void createBorrowBookButton(String id){
        JButton btn = new JButton("Borrow book");
        elements.put("id", id);
        bindRouteToButton("borrow_book", btn, elements);
        addToParent(btn);
    }

    @Override
    public void display() {}

    @Override
    public void display(String message) {}
}
