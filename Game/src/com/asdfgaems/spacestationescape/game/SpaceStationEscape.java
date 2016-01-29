package com.asdfgaems.spacestationescape.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class SpaceStationEscape extends ApplicationAdapter {
    ScreenManager screenManager;

    @Override
    public void create() {
        FontManager.Init();
        screenManager = new ScreenManager();
        screenManager.activateScreen(ScreenManager.INTRO_SCREEN);
    }
    public void render() {
        Gdx.gl.glClearColor(0.05f, 0.05f, 0.1f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        InputHandler.update();
        screenManager.update(Gdx.graphics.getDeltaTime());
        screenManager.draw();
    }
}
