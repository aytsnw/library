package com.aytsnw.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DbReader {
    public static ArrayList<HashMap<String, Object>> readFromBooks(String paramType, Object param) throws SQLException{
        ArrayList<HashMap<String, Object>> rows = new ArrayList<>();

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
            HashMap<String, Object> row = new HashMap<>();
            row.put("id", DbManager.rs.getString("id"));
            row.put("title", DbManager.rs.getString("title"));
            row.put("author", DbManager.rs.getString("author"));
            row.put("isbn", DbManager.rs.getLong("isbn"));
            row.put("year", DbManager.rs.getString("year"));
            row.put("category", DbManager.rs.getString("category"));
            row.put("loan_status", DbManager.rs.getString("loan_status"));
            rows.add(row);
        }

        return rows;
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
