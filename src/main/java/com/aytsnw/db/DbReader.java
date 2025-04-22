package com.aytsnw.db;

import com.aytsnw.models.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public class DbReader {
    public static ArrayList<Book> readFromBooks(String paramType, Object param) throws SQLException{
        ArrayList<Book> bookRows = new ArrayList<>();

        if (paramType.equals("title")){
            String query = String.format("SELECT * FROM books WHERE title LIKE '%%%s%%'", param);
            System.out.println("Executing: " + query);
            DbManager.rs = DbManager.stmt.executeQuery(query);
        } else if (paramType.equals("isbn")){
            String query = String.format("SELECT * FROM books WHERE isbn = %s", param);
            System.out.println("Executing: " + query);
            DbManager.rs = DbManager.stmt.executeQuery(query);
        } else {
            System.out.println("Bad parameter type: '" + param + "'.");
        }

        while (DbManager.rs.next()){
            Book book = new Book();
            book.setId(DbManager.rs.getInt("id"));
            book.setTitle(DbManager.rs.getString("title"));
            book.setAuthor(DbManager.rs.getString("author"));
            book.setIsbn(DbManager.rs.getString("isbn"));
            book.setYear(DbManager.rs.getString("year"));
            book.setCategory(DbManager.rs.getString("category"));
            book.setLoanStatus(DbManager.rs.getString("loan_status"));
            bookRows.add(book);
        }

        return bookRows;
    }

    public static boolean checkUserExistence(String username) throws SQLException{
        String query = "SELECT username FROM users WHERE username = '%s'".formatted(username);
        System.out.println(query);
        DbManager.rs = DbManager.stmt.executeQuery(query);
        return DbManager.rs.next();
    }

    public static String lookUpPasswordHash(String username) throws SQLException{
        String query = "SELECT password_hash FROM users WHERE username = '%s'".formatted(username);
        System.out.println(query);
        DbManager.rs = DbManager.stmt.executeQuery(query);
        if (DbManager.rs.next()){
            return DbManager.rs.getString("password_hash");
        }
        return null;
    }

    public static String lookUpUserLevel(String username) throws SQLException{
        String query = "SELECT level FROM users WHERE username = '%s'".formatted(username);
        System.out.println(query);
        DbManager.rs = DbManager.stmt.executeQuery(query);
        if (DbManager.rs.next()){
            return DbManager.rs.getString("level");
        }
        return null;
    }
}
