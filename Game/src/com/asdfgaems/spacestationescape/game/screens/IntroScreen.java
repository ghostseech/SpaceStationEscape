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
        button1 = new UiButton(200.0f, 300.0f, 500.0f, 300.0f, "ASFdFSFShtgKL", new Color(0.0f, 1.0f, 1.0f, 1.0f), new Color(1.0f, 0.0f, 1.0f, 1.0f), FontManager.mainFont);
        introUi.add(button1);

        uiProcessor.setUi(introUi);
        mainTimer = new Timer(14.0f);
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
