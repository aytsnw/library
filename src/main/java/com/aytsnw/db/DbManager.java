package com.aytsnw.db;

import java.sql.*;

public class DbManager {
    private final static String url = CredentialsManager.getUrl();
    private final static String user = CredentialsManager.getUser();
    private final static String pass = CredentialsManager.getPass();

    public static Statement stmt = null;
    public static ResultSet rs = null;

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
        }
    }

    static void createConnection() throws SQLException{
        try {
            System.out.println("Creating connection with MySQL Server...");
            Connection conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException ex){
            System.out.println("SQL Error: couldn't instantiate connection");
            throw new SQLException();
        }
    }

    private static void createDb(String dbName) throws SQLException{
        try {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("Database " + dbName + " created or already exists.");
        } catch (SQLException | NullPointerException ex){
            System.out.println("SQL Error: Couldn't create database");
            throw new SQLException();
        }
    }

    private static void selectDb(String dbName) throws SQLException{
        try {
            stmt.executeUpdate("USE " + dbName);
        } catch (SQLException ex){
            System.out.println("SQL Error: Couldn't select database " + dbName);
            throw new SQLException();
        }
    }

    public static ResultSet select(String query){
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return rs;
    }
}
