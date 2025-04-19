package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.core.Screen;
import com.aytsnw.db.DbReader;
import com.aytsnw.devices.Alternator;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.model.User;
import com.aytsnw.repository.SessionManager;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.HashMap;

public class LoginRoute extends Route {
    public LoginRoute(String name) {super(name);}

    @Override
    public void process(HashMap<String, Object> screenParams) {
        User user = new User();
        try{
            user.setUsernameLogin((String) screenParams.get("username"));
            user.setPassword((String) screenParams.get("password"));
            checkPasswordHash(user.getUsername(), user.getPassword());
            SessionManager.session.put("username", user.getUsername());
            Alternator.alternateRoute("index");
        } catch (InvalidInputException ex) {
            renderErrorScreen(ex.getMessage());
        }
    }

    private void checkPasswordHash(String username,String password) throws InvalidInputException{
        String passwordHashFromDb = null;
        try{passwordHashFromDb = DbReader.checkPasswordHash(username);}
        catch (SQLException ex) {System.out.println(ex.getMessage());}
        if (!(BCrypt.checkpw(password, passwordHashFromDb))){
            throw new InvalidInputException("Wrong password!");
        }
    }

    @Override
    public void process() {
        renderScreen("login");
    }
}
