package com.aytsnw.ui;



import com.aytsnw.routes.Alternator;
import com.aytsnw.routes.Route;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class MainMenuScreen extends Screen{

    public MainMenuScreen(String name, String title, RootWindow root){
        super(name, title, root);
    }

    @Override
    public void display(HashMap<String, Object> params) {
        drawHeader();
        ArrayList<String> options = null;

        try{
            options = (ArrayList<String>) params.get("options");
        } catch (ClassCastException ex){
            System.out.println("'options' elements must be of type: 'String'.");
            System.out.println(ex.getMessage());
            return;
        }

        try{
            JButton addBookBtn = new JButton();
            addBookBtn.setText(options.get(0));
            bindRoute("add", addBookBtn);
            this.parent.add(addBookBtn);

            JButton rmvBookBtn = new JButton();
            rmvBookBtn.setText(options.get(1));
            bindRoute("remove", rmvBookBtn);
            this.parent.add(rmvBookBtn);

            JButton brwBookBtn = new JButton();
            brwBookBtn .setText(options.get(2));
            bindRoute("borrow", brwBookBtn);
            this.parent.add(brwBookBtn);

            JButton retBookBtn = new JButton();
            retBookBtn.setText(options.get(3));
            bindRoute("return", retBookBtn);
            this.parent.add(retBookBtn);

            JButton exitBtn = new JButton();
            exitBtn.setText(options.get(4));
            bindRoute("exit", exitBtn);
            this.parent.add(exitBtn);

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

    @Override
    public void display() {
        drawHeader();
    }
}
