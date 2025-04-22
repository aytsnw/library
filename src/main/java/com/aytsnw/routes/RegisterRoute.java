package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbWriter;
import com.aytsnw.exceptions.InvalidInputException;
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
        try{
            user.setUsernameRegister((String) screenParams.get("username"));
            user.setPasswordHash((String) screenParams.get("password"),
                    (String) screenParams.get("password_confirm"));
            user.setLevel((String) screenParams.get("level"));
        } catch (InvalidInputException ex) {
            renderErrorScreen(ex.getMessage());
            return;
        }
        try{
            register(user);
            elements.put("message", "User registered!");
            renderScreen("user_registered", elements);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            renderErrorScreen("Error during registration, try again!");
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
