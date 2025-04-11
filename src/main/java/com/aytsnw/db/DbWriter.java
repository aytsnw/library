package com.aytsnw.db;

import java.sql.SQLException;
import java.util.HashMap;

public class DbWriter {
    public static void writeToBooks(HashMap<String, Object> columns) throws SQLException {
        DbManager.stmt.executeUpdate(String.format("INSERT INTO books (title, isbn, author, publisher, year, category, loan_status)" +
                " VALUES('%s', %d, '%s', '%s', %d, '%s', '%s')", columns.get("title"), columns.get("isbn"), columns.get("author"),
                columns.get("publisher"), columns.get("year"), columns.get("category"), "available"));
    }

    public static void writeToTransactions(HashMap<String, Object> columns) throws SQLException{
        DbManager.stmt.executeUpdate(String.format("INSERT INTO transactions (type, user_id, book_id)" +
                        " VALUES('%s', %d, %d)", columns.get("type"), columns.get("user_id"), columns.get("book_id")));
    }

    public static void writeToUsers(HashMap<String, Object> columns) throws SQLException{
        DbManager.stmt.executeUpdate(String.format("INSERT INTO users (username) VALUES('%s')", columns.get("username")));
    }
}
