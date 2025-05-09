package com.aytsnw.app;

import com.aytsnw.devices.ScreenDisplayer;
import com.aytsnw.routes.*;
import com.aytsnw.ui.*;
import com.aytsnw.ui.bookcrud.*;
import com.aytsnw.ui.logreg.LoginScreen;
import com.aytsnw.ui.logreg.RegisterScreen;
import com.aytsnw.ui.logreg.UserRegisteredScreen;
import com.aytsnw.ui.search.MyBooksScreen;
import com.aytsnw.ui.search.SearchResultsScreen;
import com.aytsnw.ui.search.SearchScreen;

public class Initializer {
    public static void initRoutes(){
        IndexRoute indexRoute = new IndexRoute("index");
        LoginRoute loginRoute = new LoginRoute("login");
        RegisterRoute registerRoute = new RegisterRoute("register");
        AddBookRoute addRoute = new AddBookRoute("add_book");
        SearchRoute searchRoute = new SearchRoute("search_book");
        RemoveBookRoute removeBookRoute = new RemoveBookRoute("remove_book");
        BorrowBookRoute borrowBookRoute = new BorrowBookRoute("borrow_book");
        MyBooksRoute booksRoute = new MyBooksRoute("my_books");
        ReturnBookRoute returnBookRoute = new ReturnBookRoute("return_book");
        LogoutRoute logoutRoute = new LogoutRoute("logout");
        ExitRoute exitRoute = new ExitRoute("exit");
    }

    public static void initScreens(){
        MainMenuScreen mainScreen = new MainMenuScreen("main", "Main Menu", ScreenDisplayer.getRootFrame());
        LoginScreen loginScreen = new LoginScreen("login", "Login", ScreenDisplayer.getRootFrame());
        RegisterScreen registerScreen = new RegisterScreen("register", "Register", ScreenDisplayer.getRootFrame());
        UserRegisteredScreen userRegisteredScreen = new UserRegisteredScreen("user_registered", "User Registered!", ScreenDisplayer.getRootFrame());
        AddBookScreen addScreen = new AddBookScreen("add_book", "Add Book", ScreenDisplayer.getRootFrame());
        BookAddedScreen addedScreen = new BookAddedScreen("book_added", "Result", ScreenDisplayer.getRootFrame());
        SearchScreen searchScreen = new SearchScreen("search_book", "Search Book", ScreenDisplayer.getRootFrame());
        SearchResultsScreen searchResultsScreen = new SearchResultsScreen("search_results", "Results", ScreenDisplayer.getRootFrame());
        BookRemovedScreen bookRemovedScreen = new BookRemovedScreen("book_removed", "Book Deletion", ScreenDisplayer.getRootFrame());
        BookBorrowedScreen bookBorrowedScreen = new BookBorrowedScreen("book_borrowed", "Book Borrowing", ScreenDisplayer.getRootFrame());
        ErrorScreen errorScreen = new ErrorScreen("error", "Error", ScreenDisplayer.getRootFrame());
        MyBooksScreen myBooksScreen = new MyBooksScreen("my_books", "My Books", ScreenDisplayer.getRootFrame());
        BookReturnedScreen bookReturnedScreen = new BookReturnedScreen("book_returned", "Returning Book", ScreenDisplayer.getRootFrame());
    }
}
