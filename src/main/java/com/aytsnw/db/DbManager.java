package com.aytsnw.db;

import javax.swing.text.TabExpander;
import java.sql.*;

public class DbManager {
    private final static String url = "jdbc:mysql://localhost:3306/";
    private final static String user = "root";
    private final static String pass = "bibia!1307";

    public static Statement stmt = null;
    public static ResultSet rs = null;

    public static void init(){
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

    static void createConnection(){
        try {
            System.out.println("Creating connection with MySQL Server...");
            Connection conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException ex){
            System.out.println("SQL Error: couldn't instantiate connection");
        }
    }

    private static void createDb(String dbName){
        try {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("Database " + dbName + " created or already exists.");
        } catch (SQLException ex){
            System.out.println("SQL Error: Couldn't create database");
        }
    }

    private static void selectDb(String dbName){
        try {
            stmt.executeUpdate("USE " + dbName);
        } catch (SQLException ex){
            System.out.println("SQL Error: Couldn't select database " + dbName);
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
