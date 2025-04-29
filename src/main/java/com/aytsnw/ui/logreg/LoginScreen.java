package com.aytsnw.ui.logreg;

import com.aytsnw.core.Screen;
import com.aytsnw.devices.Alternator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginScreen extends Screen {
    HashMap<String, JTextField> fields = new HashMap<>();

    public LoginScreen(String name, String title, JPanel rootFrame) {
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {}

    @Override
    public void display() {
        drawLoginHeader();
        drawLoginForm();
    }

    @Override
    public void display(String message) {}

    private void drawLoginHeader(){
        bindRouteToButton("exit", createButton("Exit App"));
        JButton registerBtn = createButton("Register");
        bindRouteToButton("register", registerBtn);
        createLabel("");
        JLabel l = createLabel(this.title);
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void drawLoginForm(){
        JTextField username = createField("Username", 20);
        fields.put("username", username);
        JTextField password = createPasswordField("Password", 20);
        fields.put("password", password);
        JButton submitBtn = createButton("Login");
        bindAction("login", submitBtn);
    }

    private void bindAction(String routeName, JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elements.put("username", fields.get("username").getText());
                elements.put("password", fields.get("password").getText());
                Alternator.alternateRoute(routeName, elements);
            }
        });
    }
}
