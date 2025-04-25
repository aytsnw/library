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
            TableCreator.createBooksTable();
            TableCreator.createUsersTable();
            TableCreator.createTransactionsTable();
            TableCreator.createUsersBooksTable();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Terminating process due to SQL Error...");
            System.exit(1);
        }

        ScreenDisplayer.initRootWindow();

        Initializer.initRoutes();
        Initializer.initScreens();

        Alternator.alternateRoute("login");
    }
    public static void main(String[] args){
        initApp();
    }
}
