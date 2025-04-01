package com.aytsnw.db;

import java.sql.SQLException;

public class TableCreator {
    public static void createBooksTable(){
        try{
            DbManager.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS books ("+
                    "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "title TEXT," +
                    "isbn INTEGER NOT NULL,"+
                    "author TEXT," +
                    "publisher TEXT," +
                    "year INTEGER NOT NULL," +
                    "loan_status TEXT NOT NULL)");

            System.out.println("Table: 'books' created or already exists.");
        } catch (SQLException ex){
            System.out.println("SQL Error: Couldn't create table: 'books'");
            System.out.println(ex.getMessage());
        }
    }

    public static void createUsersTable(){
        try{
            DbManager.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users ("+
                    "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "username TEXT NOT NULL)");

            System.out.println("Table: 'users' created or already exists.");
        } catch (SQLException ex){
            System.out.println("SQL Error: Couldn't create table: 'users'");
            System.out.println(ex.getMessage());
        }
    }

    public static void createTransactionsTable(){
        try{
            DbManager.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS transactions ("+
                    "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "type TEXT," +
                    "user_id INTEGER NOT NULL," +
                    "book_id INTEGER NOT NULL,"  +
                    "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "FOREIGN KEY (user_id) REFERENCES users(id)," +
                    "FOREIGN KEY (book_id) REFERENCES books(id))");

            System.out.println("Table: 'transactions' created or already exists.");
        } catch (SQLException ex){
            System.out.println("SQL Error: Couldn't create table: 'transactions'");
            System.out.println(ex.getMessage());
        }
    }
}
