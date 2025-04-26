package com.aytsnw.db;

import com.aytsnw.app.Initializer;
import com.aytsnw.exceptions.BadArgumentException;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.models.Book;
import com.aytsnw.models.User;

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
        DbManager.stmt.executeUpdate("INSERT INTO users (username, password_hash, level) VALUES('%s', '%s', '%s')".formatted(
                user.getUsername(), user.getPasswordHash(), user.getLevel()));
    }

    public static void deleteFromBooks(String id) throws SQLException{
        DbManager.stmt.executeUpdate("DELETE FROM books WHERE id = %s".formatted(id));
        DbManager.stmt.executeUpdate("DELETE FROM users_books WHERE book_id = %s".formatted(id));
    }

    public static void updateLoanStatus(String userId, String bookId, String operation) throws SQLException{
        switch (operation){
            case "borrow" ->{
                DbManager.stmt.executeUpdate("UPDATE books SET loan_status = 'loaned' WHERE id = %s".formatted(bookId));
                DbManager.stmt.executeUpdate("INSERT INTO users_books (user_id, book_id) VALUES(%s, %s)".formatted(userId, bookId));
                DbManager.stmt.executeUpdate("INSERT INTO transactions (type, user_id, book_id) VALUES('%s', %s, %s)".formatted("borrow", userId, bookId));
            }
            case "return" ->{
                DbManager.stmt.executeUpdate("UPDATE books SET loan_status = 'available' WHERE id = %s".formatted(bookId));
                DbManager.stmt.executeUpdate("DELETE FROM users_books WHERE user_id = %s AND book_id = %s".formatted(userId, bookId));
                DbManager.stmt.executeUpdate("INSERT INTO transactions (type, user_id, book_id) VALUES('%s', %s, %s)".formatted("return", userId, bookId));
            }
            default -> throw new BadArgumentException("Bad operation, must be 'borrow' or 'return'.");
        }
    }
}
