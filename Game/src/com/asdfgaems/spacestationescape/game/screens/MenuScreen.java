package com.asdfgaems.spacestationescape.game.screens;

import com.asdfgaems.spacestationescape.game.FontManager;
import com.asdfgaems.spacestationescape.game.ScreenManager;
import com.asdfgaems.spacestationescape.game.ui.UiButton;
import com.asdfgaems.spacestationescape.game.ui.UiElement;
import com.asdfgaems.spacestationescape.game.ui.UiProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Vector;

public class MenuScreen extends Screen {
    private UiProcessor uiProcessor;
    private Vector<UiElement> mainMenu;
    private SpriteBatch batch;
    private OrthographicCamera cam;

    private UiButton startGameButton;
    private UiButton exitGameButton;

    public MenuScreen(ScreenManager screenManager) {
        super(screenManager);
    }

    public void init() {
        uiProcessor = new UiProcessor();
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 1920, 1080);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        startGameButton = new UiButton(30, 30, 1000, 150, "NEW GAME", FontManager.interfaceColor, FontManager.interfaceTextColor, FontManager.mainFont);
        exitGameButton = new UiButton(30, 210, 1000, 150, "IIEXITII", FontManager.interfaceColor, FontManager.interfaceTextColor, FontManager.mainFont);
        mainMenu = new Vector<UiElement>();
        mainMenu.add(startGameButton);
        mainMenu.add(exitGameButton);
        uiProcessor.setUi(mainMenu);
    }
    public void draw() {
        cam.update();
        batch.begin();
        uiProcessor.draw(batch);
        batch.end();
    }
    public void update(float dt) {
        handleInput();
    }
    public void handleInput() {
        uiProcessor.update();
        Vector<UiButton> clickedList = uiProcessor.getClickedButtonList();
        for(int i = 0; i < clickedList.size(); i++) {
            UiButton button = clickedList.get(i);
            if (button == startGameButton) {
                screenManager.deactivateScreen(ScreenManager.MENU_SCREEN);
                screenManager.activateScreen(ScreenManager.GAME_SCREEN);
            }
            else if (button == exitGameButton) {
                Gdx.app.exit();
            }
        }
    }
    public void dispose() {

    }
}
