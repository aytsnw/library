package com.aytsnw.ui;

import java.util.Currency;
import java.util.HashMap;

public class ScreenDisplayer {
    public static void display(String screenName, HashMap<String, Object> params){
        Screen.screens.get(screenName).display(params);
    }
}

