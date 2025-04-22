package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbReader;
import com.aytsnw.devices.Alternator;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.models.User;
import com.aytsnw.session.SessionManager;
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
            user.setPasswordLogin((String) screenParams.get("password"));
            checkPasswordHash(user.getUsername(), user.getPassword());
            user.setLevel(lookUpUserLevel(user.getUsername()));
            SessionManager.addUserToSession(user);
            Alternator.alternateRoute("index");
        } catch (InvalidInputException ex) {
            renderErrorScreen(ex.getMessage());
        } catch ( SQLException ex){
            renderErrorScreen("Error during login. Try again!");
            System.out.println(ex.getMessage());
        }
    }

    private String lookUpUserLevel(String username) throws SQLException{return DbReader.lookUpUserLevel(username);}

    private void checkPasswordHash(String username,String password) throws InvalidInputException, SQLException{
        String passwordHashFromDb = DbReader.lookUpPasswordHash(username);
        if (!(BCrypt.checkpw(password, passwordHashFromDb))){
            throw new InvalidInputException("Wrong password!");
        }
    }

    @Override
    public void process() {
        renderScreen("login");
    }
}
