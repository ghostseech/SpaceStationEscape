package com.asdfgaems.spacestationescape.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


public class SpaceStationEscape extends ApplicationAdapter {
    @Override
    public void create() {
    }
    public void render() {
        Gdx.gl.glClearColor(0.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
