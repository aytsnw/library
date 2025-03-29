package com.aytsnw.app;

import com.aytsnw.ui.ExitScreen;
import com.aytsnw.ui.MainMenuScreen;
import com.aytsnw.ui.Screen;
import com.aytsnw.ui.ScreenAlternator;

import static com.aytsnw.ui.ScreenAlternator.screens;

public class App {
    static void addScreen(Screen screen){
        screens.put(screen.screenCode, screen);
    }
    static void initApp(){
        Screen mainMenu = new MainMenuScreen("main_menu", 5);
        Screen exit = new ExitScreen("exit", 0);
        addScreen(mainMenu);
        addScreen(exit);
        ScreenAlternator.alternateScreen(mainMenu);
    }
    public static void main(String[] args){
        initApp();
    }
}
