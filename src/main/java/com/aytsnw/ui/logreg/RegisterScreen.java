package com.aytsnw.ui.logreg;

import com.aytsnw.core.Screen;
import com.aytsnw.devices.Alternator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RegisterScreen extends Screen {
    HashMap<String, Component> fields = new HashMap<>();

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
        JTextField password = createPasswordField("Password", 20);
        fields.put("password", password);
        JTextField passwordConfirm = createPasswordField("Confirm Password", 20);
        fields.put("password_confirm", passwordConfirm);

        JCheckBox level = new JCheckBox("Librarian");
        level.setBackground(new Color(102, 51, 0));
        level.setForeground(new Color(255, 255, 255));
        addToParent(level);
        fields.put("level", level);

        JButton submitBtn = createButton("Register");
        bindAction("register", submitBtn);
    }

    private void drawRegisterHeader(){
        bindRouteToButton("exit", createButton("Exit App"));
        JButton registerBtn = createButton("Login");
        bindRouteToButton("login", registerBtn);
        createLabel("");
        JLabel l = createLabel(this.title);
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void bindAction(String routeName, JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField username = (JTextField) fields.get("username");
                elements.put("username", username.getText());
                JTextField password = (JTextField) fields.get("password");
                elements.put("password", password.getText());
                JTextField passwordConfirm = (JTextField) fields.get("password_confirm");
                elements.put("password_confirm", passwordConfirm.getText());

                JCheckBox level = (JCheckBox) fields.get("level");
                if (level.isSelected()) elements.put("level", "librarian");
                else elements.put("level", "member");

                Alternator.alternateRoute(routeName, elements);
            }
        });
    }
}
