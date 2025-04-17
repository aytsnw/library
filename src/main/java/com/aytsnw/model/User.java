package com.aytsnw.model;

public class User {
    private String username;
    private String passwordHash;

    public User(){};

    public void setUsername(String username) {this.username = username;}
    public void setPassword_hash(String password_hash) {this.passwordHash = passwordHash;}

    public String getUsername() {return username;}
    public String getPasswordHash() {return passwordHash;}
}
