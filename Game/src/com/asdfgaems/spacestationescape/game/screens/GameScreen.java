package com.asdfgaems.spacestationescape.game.screens;

import com.asdfgaems.spacestationescape.game.ScreenManager;
import com.asdfgaems.spacestationescape.game.objects.World;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends Screen {
    OrthographicCamera cam;
    SpriteBatch batch;
    World world;

    public GameScreen(ScreenManager screenManager) {
        super(screenManager);
    }

    public void init() {
        world = new World();
        world.init();
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 1920, 1080);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
    }

    public void draw() {
        cam.position.x = world.getCamX();
        cam.position.y = world.getCamY();
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        world.draw(batch);
        batch.end();
    }
    public void update(float dt) {
        world.update(dt);
    }
    public void handleInput() {

    }
    public void dispose() {

    }
}
