package com.aytsnw.ui.search;

import com.aytsnw.core.Screen;
import com.aytsnw.devices.Alternator;
import com.aytsnw.models.Book;
import com.aytsnw.session.SessionManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchResultsScreen extends Screen {

    public SearchResultsScreen(String name, String title, JPanel rootFrame) {
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();

        ArrayList<Book> bookRows =  (ArrayList<Book>) routeParams.get("book_rows");

        if (bookRows == null){
            System.out.println("'book_rows' not passed as argument.");
            return;
        }

        int bookRowsSize = bookRows.size();
        int currentIndex = (Integer) routeParams.get("index");

        if (currentIndex >= bookRowsSize) {
            System.out.println("Index out of bounds for book list fetch from Db");
            createLabel("Internal error");
            return;
        }
        createBookFrame(bookRows.get(currentIndex));

        if (currentIndex < bookRowsSize - 1) createNextButton(currentIndex);
    }

    private void createBookFrame(Book book){
        addToParent(new JLabel("Title: " + book.getTitle()));
        addToParent(new JLabel("Author: " + book.getAuthor()));
        addToParent(new JLabel("ISBN: " + book.getIsbn()));
        addToParent(new JLabel("Year: " + book.getYear()));
        addToParent(new JLabel("Category: " +  book.getCategory()));
        addToParent(new JLabel("Status: " + book.getLoanStatus()));

        if (SessionManager.session.get("level").equals("librarian")) createRemoveBookButton(book.getId().toString());
        if (!book.getLoanStatus().equals("on_loan")) createBorrowBookButton(book.getId().toString());
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

    private void createNextButton(int currentIndex){
        JButton nextBtn= createButton("Next book");
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elements.replace("index", currentIndex + 1);
                Alternator.alternateRoute("search_book");
            }
        });
    }

    @Override
    public void display() {}

    @Override
    public void display(String message) {}
}
