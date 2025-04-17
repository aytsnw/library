package com.aytsnw.app;

import com.aytsnw.core.Screen;
import com.aytsnw.db.DbManager;
import com.aytsnw.db.TableCreator;
import com.aytsnw.devices.ScreenDisplayer;
import com.aytsnw.routes.*;
import com.aytsnw.devices.Alternator;
import com.aytsnw.ui.*;

import javax.naming.directory.SearchResult;
import java.sql.SQLException;



public class App {
    static void initApp(){
        System.out.println("Initializing application....");

        try{
            DbManager.init();
        } catch (SQLException e) {
            System.out.println("Terminating process due to SQL Error...");
            System.exit(1);
        }

        TableCreator.createBooksTable();
        TableCreator.createUsersTable();
        TableCreator.createTransactionsTable();

        ScreenDisplayer.initRootWindow();

        IndexRoute indexRoute = new IndexRoute("index");
        MainMenuScreen mainScreen = new MainMenuScreen("main", "Main Menu", ScreenDisplayer.getParent());

        LoginRoute loginRoute = new LoginRoute("login");
        LoginScreen loginScreen = new LoginScreen("login", "Login", ScreenDisplayer.getParent());

        AddBookRoute addRoute = new AddBookRoute("add_book");
        AddBookScreen addScreen = new AddBookScreen("add_book", "Add Book", ScreenDisplayer.getParent());
        BookAddedScreen addedScreen = new BookAddedScreen("book_added", "Result", ScreenDisplayer.getParent());

        SearchRoute searchRoute = new SearchRoute("search_book");
        SearchScreen searchScreen = new SearchScreen("search_book", "Search Book", ScreenDisplayer.getParent());
        SearchResultsScreen searchResultsScreen = new SearchResultsScreen("search_results", "Results", ScreenDisplayer.getParent());

        RemoveBookRoute removeBookRoute = new RemoveBookRoute("remove_book");
        BookRemovedScreen bookRemovedScreen = new BookRemovedScreen("book_removed", "Book Deletion", ScreenDisplayer.getParent());

        BorrowBookRoute borrowBookRoute = new BorrowBookRoute("borrow_book");
        BookBorrowedScreen bookBorrowedScreen = new BookBorrowedScreen("book_borrowed", "Book Borrowing", ScreenDisplayer.getParent());

        ErrorScreen errorScreen = new ErrorScreen("error", "Error", ScreenDisplayer.getParent());

        Alternator.alternateRoute("login");
    }
    public static void main(String[] args){
        initApp();
    }
}
