package com.aytsnw.models;

import com.aytsnw.devices.PasswordValidator;
import com.aytsnw.devices.UsernameValidator;
import com.aytsnw.exceptions.InvalidInputException;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String passwordHash;
    private String level;

    public User(){};

    public void setId(Integer id){this.id = id;}

    public void setUsername(String username) throws InvalidInputException {this.username = username;}

    public void setPassword(String password){this.password = password;}

    public void setLevel(String level){this.level = level;}

    public void setPasswordHash(String password) throws InvalidInputException {
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }


    public Integer getId() {return id;}
    public String getUsername() {return username;}
    public String getPasswordHash() {return passwordHash;}
    public String getPassword() {return password;}
    public String getLevel() {return level;}
}
