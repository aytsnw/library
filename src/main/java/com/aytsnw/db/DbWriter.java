package com.aytsnw.db;

import com.aytsnw.app.Initializer;
import com.aytsnw.exceptions.BadArgumentException;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.models.Book;
import com.aytsnw.models.Transaction;
import com.aytsnw.models.User;

import java.sql.*;
import java.util.HashMap;

public class DbWriter {
    private static PreparedStatement stmt = null;
    private static final Connection conn = DbManager.conn;

    public static void writeToBooks(Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author, isbn, publisher, year, category, loan_status)" +
                " VALUES(?, ?, ?, ?, ?, ?, available)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, book.getTitle());
        stmt.setString(2, book.getAuthor());
        stmt.setLong(3, book.getIsbn());
        stmt.setString(4, book.getPublisher());
        stmt.setInt(5, book.getYear());
        stmt.setString(6, book.getCategory());
        stmt.executeUpdate();
    }


    public static void writeToUsers(User user) throws SQLException{
        String sql = "INSERT INTO users (username, password_hash, level) VALUES('%s', '%s', '%s')";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,user.getUsername());
        stmt.setString(2, user.getPasswordHash());
        stmt.setString(3, user.getLevel());
        stmt.executeUpdate();
    }

    private static void writeToTransactions(Transaction tran) throws SQLException{
        String sql = "INSERT INTO transactions (type, user_id, book_id)" +
                " VALUES(?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, tran.getType());
        stmt.setInt(2, tran.getUserId());
        stmt.setInt(3, tran.getBookId());
        stmt.executeUpdate();
    }

    public static void deleteFromBooks(String id) throws SQLException{
        String sql = "DELETE FROM books WHERE id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);
        stmt.executeUpdate();

        sql = "DELETE FROM users_books WHERE book_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);
        stmt.executeUpdate();
    }

    public static void updateLoanStatus(Transaction tran) throws SQLException{
        Statement stmt = conn.createStatement();
        switch (tran.getType()){
            case "borrow" ->{
                stmt.executeUpdate("UPDATE books SET loan_status = 'loaned' WHERE id = %s".formatted(tran.getBookId()));
                stmt.executeUpdate("INSERT INTO users_books (user_id, book_id) VALUES(%s, %s)".formatted(tran.getUserId(), tran.getBookId()));
                writeToTransactions(tran);
            }
            case "return" ->{
                stmt.executeUpdate("UPDATE books SET loan_status = 'available' WHERE id = %s".formatted(tran.getBookId()));
                stmt.executeUpdate("DELETE FROM users_books WHERE user_id = %s AND book_id = %s".formatted(tran.getUserId(), tran.getBookId()));
                writeToTransactions(tran);
            }
            default -> throw new BadArgumentException("Bad operation, must be 'borrow' or 'return'.");
        }
    }

}
