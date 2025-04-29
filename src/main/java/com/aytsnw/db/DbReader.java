package com.aytsnw.db;

import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.models.Book;

import java.sql.*;
import java.util.ArrayList;

public class DbReader {
    private static ResultSet rs = null;
    private static PreparedStatement stmt = null;
    private static final Connection conn = DbManager.conn;


    public static ArrayList<Book> readFromBooks(String paramType, Object param) throws SQLException, InvalidInputException{
        ArrayList<Book> bookRows = new ArrayList<>();

        switch (paramType) {
            case "title" -> readBooksByTitle(param);
            case "isbn" -> readBooksByIsbn(param);
            case "username" -> readBooksByUsername(param);
            default -> throw new InvalidInputException("Bad parameter type: '" + param + "'.");
        }
        rs = stmt.executeQuery();

        addBooksToReturnList(rs, bookRows);

        if (bookRows.isEmpty()) return null;
        return bookRows;
    }

    private static void readBooksByTitle(Object param) throws SQLException{
        String sql = "SELECT * FROM books WHERE title LIKE ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + param + "%");
    }

    private static void readBooksByIsbn(Object param) throws SQLException{
        String sql = "SELECT * FROM books WHERE isbn = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setLong(1, Long.parseLong((String) param));
    }

    private static void readBooksByUsername(Object param) throws SQLException{
        String sql = "SELECT * FROM users_books JOIN books ON book_id = books.id " +
                "JOIN users ON user_id = users.id WHERE users.username = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, param.toString());
    }

    private static void addBooksToReturnList(ResultSet rs, ArrayList<Book> bookRows) throws SQLException{
        while (rs.next()){
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setIsbn(rs.getString("isbn"));
            book.setPublisher(rs.getString("publisher"));
            book.setYear(rs.getString("year"));
            book.setCategory(rs.getString("category"));
            book.setLoanStatus(rs.getString("loan_status"));
            bookRows.add(book);
        }
    }

    public static boolean checkUserExistence(String username) throws SQLException{
        String sql = "SELECT username FROM users WHERE username = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        rs = stmt.executeQuery();
        return rs.next();
    }

    public static String lookUpPasswordHash(String username) throws SQLException{
        String sql = "SELECT password_hash FROM users WHERE username = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        rs = stmt.executeQuery();
        if (rs.next()){
            return rs.getString("password_hash");
        }
        return null;
    }

    public static String lookUpUserLevel(String username) throws SQLException{
        String sql = "SELECT level FROM users WHERE username = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        rs = stmt.executeQuery();
        if (rs.next()){
            return rs.getString("level");
        }
        return null;
    }

    public static Integer lookUpUserId(String username) throws SQLException{
        String sql = "SELECT id FROM users WHERE username = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        rs = stmt.executeQuery();
        if (rs.next()){
            return rs.getInt("id");
        }
        return null;
    }
}
