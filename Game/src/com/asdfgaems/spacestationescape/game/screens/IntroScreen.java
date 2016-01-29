package com.asdfgaems.spacestationescape.game.screens;

import com.asdfgaems.spacestationescape.game.*;
import com.asdfgaems.spacestationescape.game.ui.UiButton;
import com.asdfgaems.spacestationescape.game.ui.UiElement;
import com.asdfgaems.spacestationescape.game.ui.UiProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Vector;

public class IntroScreen extends Screen {
    private Timer mainTimer;
    private UiProcessor uiProcessor;
    private Vector<UiElement> introUi;
    private SpriteBatch batch;
    private OrthographicCamera cam;
    private UiButton button1;

    public IntroScreen(ScreenManager screenManager) {
        super(screenManager);
    }

    public void init() {
        uiProcessor = new UiProcessor();
        introUi = new Vector<UiElement>();

        uiProcessor.setUi(introUi);
        mainTimer = new Timer(3.0f);
        TimerManager.addTimer(mainTimer);
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 1920, 1080);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        mainTimer.start();
        mainTimer.start();
        setupUi();
    }
    public void draw() {
        cam.update();
        batch.begin();
        uiProcessor.draw(batch);
        batch.end();
    }
    public void update(float dt) {
        handleInput();
        if(mainTimer.isEnded()) {
            mainTimer.stop();
            TimerManager.removeTimer(mainTimer);
            screenManager.activateScreen(ScreenManager.MENU_SCREEN);
            screenManager.deactivateScreen(ScreenManager.INTRO_SCREEN);
        }
    }

    public void handleInput() {
        uiProcessor.update();
    }
    public void setupUi() {

    }
    public void dispose() {

    }
}
