package com.aytsnw.app;

import com.aytsnw.db.DbManager;
import com.aytsnw.db.TableCreator;
import com.aytsnw.devices.ScreenDisplayer;

import com.aytsnw.devices.Alternator;

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

        Initializer.initRoutes();
        Initializer.initScreens();

        Alternator.alternateRoute("login");
    }
    public static void main(String[] args){
        initApp();
    }
}
