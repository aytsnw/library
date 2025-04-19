package com.aytsnw.devices;

import com.aytsnw.db.DbReader;
import com.aytsnw.exceptions.InvalidInputException;

import java.sql.SQLException;

public class UsernameValidator {
    public static void validateUsername(String username) throws InvalidInputException {
        if (username.isEmpty()){
            throw new InvalidInputException("Empty username.");
        }
    }

    public static boolean checkUserExistenceInDb(String username) throws SQLException{
        return DbReader.checkUserExistence(username);
    }
}
