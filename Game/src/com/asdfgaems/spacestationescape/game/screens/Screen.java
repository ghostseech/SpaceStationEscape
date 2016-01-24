package com.asdfgaems.spacestationescape.game.screens;

import com.asdfgaems.spacestationescape.game.ScreenManager;

public abstract class Screen {
    protected boolean active;
    protected ScreenManager screenManager;

    public Screen(ScreenManager screenManager) {
        active = false;
        this.screenManager = screenManager;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean b) {
        active = b;
    }

    public abstract void init();
    public abstract void draw();
    public abstract void update(float dt);
    public abstract void handleInput();
    public abstract void dispose();
}