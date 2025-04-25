package com.aytsnw.ui.search;

import com.aytsnw.core.Screen;
import com.aytsnw.devices.Alternator;
import com.aytsnw.devices.ScreenDisplayer;
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
        int bookRowsSize, currentIndex;

        ArrayList<Book> bookRows =  (ArrayList<Book>) routeParams.get("book_rows");

        if (bookRows == null){
            System.out.println("'book_rows' not passed as argument or is null.");
            createLabel("No results for this query.");
            return;
        }

        currentIndex = (Integer) routeParams.get("index");
        bookRowsSize = bookRows.size();

        createBookFrame(bookRows.get(currentIndex), routeParams.get("user_id").toString());

        if (currentIndex < bookRowsSize - 1){
            routeParams.put("index", currentIndex);
            createNextButton(routeParams);
        }
        if (currentIndex > 0){
            routeParams.put("index", currentIndex);
            createPrevButton(routeParams);
        }
    }

    private void createBookFrame(Book book, String userId){
        addToParent(new JLabel("Title: " + book.getTitle()));
        addToParent(new JLabel("Author: " + book.getAuthor()));
        addToParent(new JLabel("ISBN: " + book.getIsbn()));
        addToParent(new JLabel("Year: " + book.getYear()));
        addToParent(new JLabel("Category: " +  book.getCategory()));
        addToParent(new JLabel("Status: " + book.getLoanStatus()));

        if (SessionManager.session.get("level").equals("librarian")) createRemoveBookButton(userId, book.getId().toString());
        if (!book.getLoanStatus().equals("on_loan")) createBorrowBookButton(userId, book.getId().toString());
    }

    private void createRemoveBookButton(String userId, String bookId){
        JButton btn = new JButton("Remove from Library");
        elements.put("user_id", userId);
        elements.put("book_id", bookId);
        bindRouteToButton("remove_book", btn, elements);
        addToParent(btn);
    }

    private void createBorrowBookButton(String userId, String bookId){
        JButton btn = new JButton("Borrow book");
        elements.put("user_id", userId);
        elements.put("book_id", bookId);
        bindRouteToButton("borrow_book", btn, elements);
        addToParent(btn);
    }

    private void createNextButton(HashMap<String, Object> routeParams){
        JButton nextBtn= createButton("Next book");
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                routeParams.replace("index", (Integer) routeParams.get("index") + 1);
                ScreenDisplayer.displayScreen("search_results", routeParams);
            }
        });
    }

    private void createPrevButton(HashMap<String, Object> routeParams){
        JButton nextBtn= createButton("Previous book");
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                routeParams.replace("index", (Integer) routeParams.get("index") - 1);
                ScreenDisplayer.displayScreen("search_results", routeParams);
            }
        });
    }

    @Override
    public void display() {}

    @Override
    public void display(String message) {}
}
