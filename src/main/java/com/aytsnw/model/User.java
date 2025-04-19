package com.aytsnw.model;

import com.aytsnw.db.DbReader;
import com.aytsnw.devices.PasswordValidator;
import com.aytsnw.devices.UsernameValidator;
import com.aytsnw.exceptions.InvalidInputException;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class User {
    private String username;
    private String password;
    private String passwordHash;

    public User(){};

    public void setUsernameRegister(String username) throws InvalidInputException {
        UsernameValidator.validateUsername(username);
        try{
            if (UsernameValidator.checkUserExistenceInDb(username)) throw new InvalidInputException("Username already exists.");
            else this.username = username;
        }catch (SQLException ex) {
            System.out.println("SQL Error during reading from table: 'users': " + ex.getMessage());
        }
    }

    public void setUsernameLogin(String username) throws InvalidInputException{
        UsernameValidator.validateUsername(username);
        try{
            if (!UsernameValidator.checkUserExistenceInDb(username)) throw new InvalidInputException("Username don't exist.");
            else this.username = username;
        }catch (SQLException ex) {
            System.out.println("SQL Error during reading from table: 'users': " + ex.getMessage());
        }
    }

    public void setPasswordHash(String password, String passwordConfirm) throws InvalidInputException {
        PasswordValidator.validatePassword(password);
        PasswordValidator.validatePasswordMatch(password, passwordConfirm);
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void setPasswordHash(String password) throws InvalidInputException {
        PasswordValidator.validatePassword(password);
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername() {return username;}
    public String getPasswordHash() {return passwordHash;}
    public String getPassword() {return password;}
}
