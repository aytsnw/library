package com.aytsnw.routes;

import com.aytsnw.core.Route;
import com.aytsnw.db.DbReader;
import com.aytsnw.devices.Alternator;
import com.aytsnw.devices.PasswordValidator;
import com.aytsnw.devices.UsernameValidator;
import com.aytsnw.exceptions.InvalidInputException;
import com.aytsnw.exceptions.UserAlreadyExistsException;
import com.aytsnw.exceptions.WrongCredentialsException;
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
        String username = (String) screenParams.get("username");
        String password = (String) screenParams.get("password");

        try{
            UsernameValidator.checkUserExistenceInDb(username, "login");
            user.setUsername(username);
            PasswordValidator.validatePasswordWithDb(username, password);
            user.setPassword(password);
            user.setLevel(lookUpUserLevel(username));
            user.setId(lookUpUserId(username));
            SessionManager.addUserToSession(user);
            Alternator.alternateRoute("index");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            renderErrorScreen("Error during login. Try again!");
            ex.printStackTrace();
        } catch (WrongCredentialsException ex){
            renderErrorScreen(ex.getMessage());
            ex.printStackTrace();
        }

    }

    private String lookUpUserLevel(String username) throws SQLException{return DbReader.lookUpUserLevel(username);}

    private Integer lookUpUserId(String username) throws SQLException {return DbReader.lookUpUserId(username);}

    @Override
    public void process() {renderScreen("login");}
}
