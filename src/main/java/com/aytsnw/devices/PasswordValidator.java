package com.aytsnw.devices;

import com.aytsnw.db.DbReader;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.exceptions.WrongCredentialsException;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.HashMap;


public class PasswordValidator{
    public static void validatePasswordRegistration(String password, String passwordConfirm) throws InvalidInputException {
        if (password.isEmpty()){
            throw new InvalidInputException("Empty password!");
        } else if(password.length() < 6){
            throw new InvalidInputException("Password too short. Try at least 6 characters.");
        }
        validatePasswordMatch(password, passwordConfirm);
    }

    public static void validatePasswordMatch(String password, String passwordConfirm) throws InvalidInputException{
        if (!(password.equals(passwordConfirm))){
            throw new InvalidInputException("Passwords don't match!");
        }
    }

    public static void validatePasswordWithDb(String username, String password) throws SQLException{
        String passwordHashFromDb = DbReader.lookUpPasswordHash(username);
        if (!(BCrypt.checkpw(password, passwordHashFromDb))){
            throw new WrongCredentialsException("Wrong password!");
        }
    }
}
