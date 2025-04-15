package com.aytsnw.app;

import com.aytsnw.core.Screen;
import com.aytsnw.db.DbManager;
import com.aytsnw.db.TableCreator;
import com.aytsnw.devices.ScreenDisplayer;
import com.aytsnw.routes.AddBookRoute;
import com.aytsnw.devices.Alternator;
import com.aytsnw.routes.IndexRoute;
import com.aytsnw.routes.RemoveBookRoute;
import com.aytsnw.routes.SearchRoute;
import com.aytsnw.ui.*;
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

        AddBookRoute addRoute = new AddBookRoute("add");
        AddBookScreen addScreen = new AddBookScreen("add", "Add Book", ScreenDisplayer.getParent());
        BookAddedScreen addedScreen = new BookAddedScreen("added", "Result", ScreenDisplayer.getParent());

        SearchRoute searchRoute = new SearchRoute("search");
        SearchScreen searchScreen = new SearchScreen("search", "Search Book", ScreenDisplayer.getParent());
        SearchTitleScreen searchTitleScreen = new SearchTitleScreen("search_results_title", "Results", ScreenDisplayer.getParent());

        RemoveBookRoute removeBookRoute = new RemoveBookRoute("remove_book");
        BookRemovedScreen bookRemovedScreen = new BookRemovedScreen("book_removed", "Book Deletion", ScreenDisplayer.getParent());

        Alternator.alternateRoute("index");

    }
    public static void main(String[] args){
        initApp();
    }
}
