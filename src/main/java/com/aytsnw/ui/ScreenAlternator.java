package com.aytsnw.ui;

import java.util.HashMap;

public class ScreenAlternator {
    public static HashMap<Integer, Screen> screens = new HashMap<>();

    static Screen currentScreen = null;
    static Screen prevScreen = null;

    public static void alternateScreen(Screen screen){
        if (currentScreen == null){
            prevScreen = screen;
        } else {
            prevScreen = currentScreen;
        }
        currentScreen = screen;
        currentScreen.display();
    }
}
