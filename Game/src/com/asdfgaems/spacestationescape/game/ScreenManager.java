package com.asdfgaems.spacestationescape.game;


import com.asdfgaems.spacestationescape.game.screens.GameScreen;
import com.asdfgaems.spacestationescape.game.screens.IntroScreen;
import com.asdfgaems.spacestationescape.game.screens.MenuScreen;
import com.asdfgaems.spacestationescape.game.screens.Screen;

import java.util.Vector;

public class ScreenManager {
    public static final int GAME_SCREEN = 0;
    public static final int MENU_SCREEN = 1;
    public static final int INTRO_SCREEN = 2;

    protected Vector<Screen> screens;

    public ScreenManager() {
        screens = new Vector<Screen>();
        screens.add(new GameScreen(this));
        screens.add(new MenuScreen(this));
        screens.add(new IntroScreen(this));
        for(Screen s : screens) s.init();
    }

    public void activateScreen(int screen) {
        screens.get(screen).setActive(true);
    }

    public void deactivateScreen(int screen) {
        screens.get(screen).setActive(false);
    }

    public void draw() {
        for (Screen s : screens) {
            if(s.isActive()) s.draw();
        }
    }

    public void update(float dt) {
        TimerManager.update(dt);
        for (Screen s : screens) {
            if(s.isActive()) s.update(dt);
        }
    }
}
