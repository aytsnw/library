package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbWriter;
import com.aytsnw.devices.PasswordValidator;
import com.aytsnw.devices.UsernameValidator;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.exceptions.UserAlreadyExistsException;
import com.aytsnw.models.User;

import java.sql.SQLException;
import java.util.HashMap;

public class RegisterRoute extends Route {
    public RegisterRoute(String name) {
        super(name);
    }

    @Override
    public void process(HashMap<String, Object> screenParams) {
        User user = new User();
        String username = (String) screenParams.get("username");
        String password = (String) screenParams.get("password");
        String passwordConfirm = (String) screenParams.get("password_confirm");

        try{
            UsernameValidator.validateUsername(username);
            user.setUsername(username);
            PasswordValidator.validatePasswordRegistration(password, passwordConfirm);
            user.setPasswordHash(password);
            user.setLevel((String) screenParams.get("level"));
            register(user);
            elements.put("message", "User registered!");
            renderScreen("user_registered", elements);
        } catch (InvalidInputException | UserAlreadyExistsException ex) {
            renderErrorScreen(ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            renderErrorScreen("An error occurred during registration. Try again!");
            ex.printStackTrace();
        }

        elements.clear();
    }

    private void register(User user) throws SQLException{
        try {
            DbWriter.writeToUsers(user);
        } catch (SQLException ex){
            System.out.println("SQL Error during writing user to db : " + ex.getMessage());
            throw new SQLException();
        }
    }

    @Override
    public void process() {
        renderScreen("register");
    }
}
