package com.aytsnw.ui;

import com.aytsnw.core.Screen;
import com.aytsnw.devices.Alternator;
import com.aytsnw.windows.RootWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class MainMenuScreen extends Screen {

    private ArrayList<String> options = null;

    public MainMenuScreen(String name, String title, RootWindow root){
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> routeParams) {
        drawHeader();
        try{
            options = (ArrayList<String>) routeParams.get("options");
        } catch (ClassCastException ex){
            System.out.println("'options' elements must be of type: 'String'.");
            System.out.println(ex.getMessage());
            return;
        }

        try{
            createBtn(0, "add");
            createBtn(1, "remove");
            createBtn(2, "borrow");
            createBtn(3, "return");
            createBtn(4, "exit");
        } catch (NullPointerException ex){
            System.out.print("'options' list not initialized.");
            System.out.println(ex.getMessage());
        }
    }

    private void bindRoute(String routeName, JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alternator.alternateRoute(routeName);
            }
        });
    }

    private void createBtn(int optionIndex, String routeName){
        JButton btn = new JButton();
        btn.setText(options.get(optionIndex));
        bindRoute(routeName, btn);
        this.parent.add(btn);
    }

    @Override
    public void display() {drawHeader();}
}
