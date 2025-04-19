package com.aytsnw.db;

import com.aytsnw.model.Book;
import com.aytsnw.model.User;

import java.sql.SQLException;
import java.util.HashMap;

public class DbWriter {
    public static void writeToBooks(Book book) throws SQLException {
        DbManager.stmt.executeUpdate(String.format("INSERT INTO books (title, author, isbn, publisher, year, category, loan_status)" +
                " VALUES('%s', '%s', %d, '%s', %d, '%s', '%s')", book.getTitle(), book.getAuthor(), book.getIsbn(),
                book.getPublisher(), book.getYear(), book.getCategory(), "available"));
    }

    public static void writeToTransactions(HashMap<String, Object> columns) throws SQLException{
        DbManager.stmt.executeUpdate(String.format("INSERT INTO transactions (type, user_id, book_id)" +
                        " VALUES('%s', %d, %d)", columns.get("type"), columns.get("user_id"), columns.get("book_id")));
    }

    public static void writeToUsers(User user) throws SQLException{
        DbManager.stmt.executeUpdate(String.format("INSERT INTO users (username, password_hash) VALUES('%s', '%s')", user.getUsername(), user.getPasswordHash()));
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
