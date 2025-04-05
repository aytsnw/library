package com.aytsnw.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DbReader {
    public static ArrayList<HashMap<String, Object>> readFromBooks(String paramType, Object param) throws SQLException{
        ArrayList<HashMap<String, Object>> rows = new ArrayList<>();
        HashMap<String, Object> row = new HashMap<>();

        if (paramType == "title"){
            DbManager.rs = DbManager.stmt.executeQuery(String.format("SELECT * FROM books WHERE title LIKE '%%%s%%'", param));
        } else if ( paramType == "isbn"){
            DbManager.rs = DbManager.stmt.executeQuery(String.format("SELECT * FROM books WHERE isbn = %d", isbn));
        }

        while (DbManager.rs.next()){
            row.put("Title", DbManager.rs.getString("title"));
            row.put("Author", DbManager.rs.getString("author"));
            row.put("ISBN", DbManager.rs.getLong("isbn"));
            row.put("Year", DbManager.rs.getString("Year"));
            rows.add(row);
            row.clear();
        }
        return rows;
    }
}
