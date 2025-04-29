package com.aytsnw.db;

import java.sql.*;

public class DbManager {
    private final static String url = CredentialsManager.getUrl();
    private final static String user = CredentialsManager.getUser();
    private final static String pass = CredentialsManager.getPassword();

    protected static Connection conn = null;

    public static void init() throws SQLException{
        loadDriver();
        createConnection();
        createDb("library");
        selectDb("library");
    }

    static void loadDriver(){
        try{
            System.out.println("Loading driver...");
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex){
            System.out.println("Couldn't load driver.");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    static void createConnection() throws SQLException{
        try {
            System.out.println("Creating connection with MySQL Server...");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex){
            throw new SQLException("SQL Error: couldn't instantiate connection");
        }
    }

    private static void createDb(String dbName) throws SQLException{
        Statement stmt = conn.createStatement();
        try {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("Database " + dbName + " created or already exists.");
        } catch (SQLException | NullPointerException ex){
            throw new SQLException("SQL Error: couldn't instantiate connection");
        }
    }

    private static void selectDb(String dbName) throws SQLException{
        Statement stmt = conn.createStatement();
        try {
            stmt.executeUpdate("USE " + dbName);
        } catch (SQLException ex){
            throw new SQLException("SQL Error: couldn't instantiate connection");
        }
    }
}
