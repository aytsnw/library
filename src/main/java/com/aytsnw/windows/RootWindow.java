package com.aytsnw.windows;

import com.aytsnw.core.Window;

public class RootWindow extends Window {
    private int windowWidth;
    private int windowHeight;

    public RootWindow(String name) {
        super(name);
    }

    public int getWindowWidth() {return windowWidth;}

    public void setWindowWidth(int windowWidth) {this.windowWidth = windowWidth;}

    public int getWindowHeight() {return windowHeight;}

    public void setWindowHeight(int windowHeight) {this.windowHeight = windowHeight;}
}
