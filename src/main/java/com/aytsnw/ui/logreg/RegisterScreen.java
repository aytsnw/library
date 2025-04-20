package com.aytsnw.ui.logreg;

import com.aytsnw.core.Screen;
import com.aytsnw.devices.Alternator;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RegisterScreen extends Screen {
    HashMap<String, JTextField> fields = new HashMap<>();

    public RegisterScreen(String name, String title, JPanel rootFrame) {
        super(name, title, rootFrame);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawRegisterHeader();
        drawRegisterForm();
    }

    @Override
    public void display() {
        drawRegisterHeader();
        drawRegisterForm();
    }

    @Override
    public void display(String message) {}

    private void drawRegisterForm(){
        JTextField username = createField("Username", 20);
        fields.put("username", username);

        JTextField password = createField("Password", 20);
        fields.put("password", password);

        JTextField passwordConfirm = createField("Confirm Password", 20);
        fields.put("password_confirm", passwordConfirm);

        JButton submitBtn = createButton("Register");
        bindAction("register", submitBtn);
    }

    private void drawRegisterHeader(){
        JButton registerBtn = createButton("Login");
        bindRoute("login", registerBtn);
        JLabel l = createLabel(this.title);
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void bindAction(String routeName, JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elements.put("username", fields.get("username").getText());
                elements.put("password", fields.get("password").getText());
                elements.put("password_confirm", fields.get("password_confirm").getText());
                Alternator.alternateRoute(routeName, elements);
            }
        });
    }
}
