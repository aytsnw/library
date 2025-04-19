package com.aytsnw.app;

import com.aytsnw.devices.ScreenDisplayer;
import com.aytsnw.routes.*;
import com.aytsnw.ui.*;
import com.aytsnw.ui.bookcrud.AddBookScreen;
import com.aytsnw.ui.bookcrud.BookAddedScreen;
import com.aytsnw.ui.bookcrud.BookBorrowedScreen;
import com.aytsnw.ui.bookcrud.BookRemovedScreen;
import com.aytsnw.ui.logreg.LoginScreen;
import com.aytsnw.ui.logreg.RegisterScreen;
import com.aytsnw.ui.logreg.UserRegisteredScreen;
import com.aytsnw.ui.search.SearchResultsScreen;
import com.aytsnw.ui.search.SearchScreen;

public class Helper {
    public static void initRoutes(){
        IndexRoute indexRoute = new IndexRoute("index");
        LoginRoute loginRoute = new LoginRoute("login");
        RegisterRoute registerRoute = new RegisterRoute("register");
        AddBookRoute addRoute = new AddBookRoute("add_book");
        SearchRoute searchRoute = new SearchRoute("search_book");
        RemoveBookRoute removeBookRoute = new RemoveBookRoute("remove_book");
        BorrowBookRoute borrowBookRoute = new BorrowBookRoute("borrow_book");
    }

    public static void initScreens(){
        MainMenuScreen mainScreen = new MainMenuScreen("main", "Main Menu", ScreenDisplayer.getParent());
        LoginScreen loginScreen = new LoginScreen("login", "Login", ScreenDisplayer.getParent());
        RegisterScreen registerScreen = new RegisterScreen("register", "Register", ScreenDisplayer.getParent());
        UserRegisteredScreen userRegisteredScreen = new UserRegisteredScreen("user_registered", "User Registered!", ScreenDisplayer.getParent());
        AddBookScreen addScreen = new AddBookScreen("add_book", "Add Book", ScreenDisplayer.getParent());
        BookAddedScreen addedScreen = new BookAddedScreen("book_added", "Result", ScreenDisplayer.getParent());
        SearchScreen searchScreen = new SearchScreen("search_book", "Search Book", ScreenDisplayer.getParent());
        SearchResultsScreen searchResultsScreen = new SearchResultsScreen("search_results", "Results", ScreenDisplayer.getParent());
        BookRemovedScreen bookRemovedScreen = new BookRemovedScreen("book_removed", "Book Deletion", ScreenDisplayer.getParent());
        BookBorrowedScreen bookBorrowedScreen = new BookBorrowedScreen("book_borrowed", "Book Borrowing", ScreenDisplayer.getParent());
        ErrorScreen errorScreen = new ErrorScreen("error", "Error", ScreenDisplayer.getParent());
    }
}
