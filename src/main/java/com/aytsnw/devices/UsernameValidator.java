package com.aytsnw.devices;

import com.aytsnw.db.DbReader;
import com.aytsnw.exceptions.BadArgumentException;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.exceptions.UserAlreadyExistsException;
import com.aytsnw.exceptions.WrongCredentialsException;

import java.sql.SQLException;

public class UsernameValidator {
    public static void validateUsername(String username) throws SQLException {
        if (username.isEmpty()){
            throw new InvalidInputException("Empty username.");
        }
        checkUserExistenceInDb(username, "register");
    }

    public static void checkUserExistenceInDb(String username, String operation) throws SQLException{
        switch (operation){
            case "login" -> {if(!(DbReader.checkUserExistence(username))) throw new WrongCredentialsException();}
            case "register" -> {if(DbReader.checkUserExistence(username)) throw new UserAlreadyExistsException();}
            default -> throw new BadArgumentException("Bad operation argument: " + operation + ". Try 'login' | 'register'.");
        }
    }
}
