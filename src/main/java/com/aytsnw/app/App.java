package com.aytsnw.app;

import com.aytsnw.db.DbManager;
import com.aytsnw.db.TableCreator;
import com.aytsnw.ui.*;
import java.sql.SQLException;

import static com.aytsnw.ui.ScreenAlternator.screens;

public class App {
    static void addScreen(Screen screen){
        screens.put(screen.screenCode, screen);
    }
    static void initApp(){
        System.out.println("Initializing application....");

        Screen mainMenu = new MainMenuScreen("main_menu", "Main Menu", 5);
        Screen exit = new ExitScreen("exit", "Exit", 0);
        Screen decision = new DecisionMenuScreen("decision_menu", "Do you wish to continue?", -1);
        Screen addBook = new AddBookScreen("add_book", "Add Book", 1);
        Screen removeBook = new RemoveBookScreen("remove_book", "Remove Book", 2);
        addScreen(mainMenu);
        addScreen(exit);
        addScreen(addBook);
        addScreen(removeBook);
        addScreen(decision);

        try{
            DbManager.init();
        } catch (SQLException e) {
            System.out.println("Terminating process due to SQL Error...");
            System.exit(1);
        }

        TableCreator.createBooksTable();
        TableCreator.createUsersTable();
        TableCreator.createTransactionsTable();

        ScreenAlternator.alternateScreen(mainMenu);
    }
    public static void main(String[] args){
        initApp();
    }
}
