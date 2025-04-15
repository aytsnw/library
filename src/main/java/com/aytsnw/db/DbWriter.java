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

    public static void deleteFromBooks(String id) throws SQLException{
        DbManager.stmt.executeUpdate("DELETE FROM books WHERE id = %s".formatted(id));
    }

    public static void updateLoanStatus(String id, String operation) throws SQLException{
        if (operation.equals("borrow")){
            DbManager.stmt.executeUpdate("UPDATE books SET loan_status = 'on_loan' WHERE id = %s".formatted(id));
        } else if (operation.equals("return")){
            DbManager.stmt.executeUpdate("UPDATE books SET loan_status = 'available' WHERE id = %s".formatted(id));
        }
    }
}
