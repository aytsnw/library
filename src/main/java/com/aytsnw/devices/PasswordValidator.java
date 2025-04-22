package com.aytsnw.devices;

import com.aytsnw.db.DbReader;
import com.aytsnw.exceptions.InvalidInputException;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.HashMap;


public class PasswordValidator{
    public static void validatePassword(String password) throws InvalidInputException {
        if (password.isEmpty()){
            throw new InvalidInputException("Empty password!");
        } else if(password.length() < 6){
            throw new InvalidInputException("Password too short. Try setting a password with at least" +
                    "6 characters");
        }
    }

    public static void validatePasswordMatch(String password, String passwordConfirm){
        if (!(password.equals(passwordConfirm))){
            throw new InvalidInputException("Passwords don't match!");
        }
    }
}
