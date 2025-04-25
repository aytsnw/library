package com.aytsnw.db;

import java.sql.SQLException;

public class TableCreator {
    public static void createBooksTable() throws SQLException{
        DbManager.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS books ("+
                "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                "title TEXT," +
                "author TEXT," +
                "isbn BIGINT NOT NULL,"+
                "publisher TEXT," +
                "year INTEGER NOT NULL," +
                "category TEXT," +
                "loan_status TEXT NOT NULL)");
        System.out.println("Table: 'books' created or already exists.");
    }

    public static void createUsersTable() throws SQLException{
        DbManager.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users ("+
                "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                "username TEXT NOT NULL," +
                "level TEXT NOT NULL," +
                "password_hash TEXT NOT NULL)");

        System.out.println("Table: 'users' created or already exists.");
    }

    public static void createTransactionsTable() throws SQLException{
        DbManager.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS transactions ("+
                "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                "type TEXT," +
                "user_id INTEGER NOT NULL," +
                "book_id INTEGER NOT NULL,"  +
                "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "FOREIGN KEY (user_id) REFERENCES users(id)," +
                "FOREIGN KEY (book_id) REFERENCES books(id))");

        System.out.println("Table: 'transactions' created or already exists.");
    }

    public static void createUsersBooksTable() throws SQLException{
        DbManager.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users_books ("+
                "user_id INTEGER NOT NULL," +
                "book_id INTEGER NOT NULL,"  +
                "FOREIGN KEY (user_id) REFERENCES users(id)," +
                "FOREIGN KEY (book_id) REFERENCES books(id))");

        System.out.println("Table: 'users_books' created or already exists.");
    }
}
