package com.asdfgaems.spacestationescape.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UiButton extends UiElement {
    public static final int standard = 1;

    private boolean wasPressed;
    private static Texture texture_standard = new Texture(Gdx.files.internal("button_1.png"));
    private static Texture texture_standard_pressed = new Texture(Gdx.files.internal("button_1_pressed.png"));
    private float width;
    private float height;
    private CharSequence text;
    private BitmapFont font;

    private Color textColor;
    private Texture texture;
    private Texture texture_pressed;

    public UiButton(float x, float y, float width, float height, CharSequence text, Color color, Color textColor, BitmapFont font) {
        super(x, y, color);
        wasPressed = false;
        this.width = width;
        this.height = height;
        this.text = text;
        this.textColor = textColor;
        this.font = font;
        texture = texture_standard;
        texture_pressed = texture_standard_pressed;
    }

    @Override
    public  void drawElement(SpriteBatch batch) {
        if(wasPressed) batch.draw(texture_pressed, x, y, width, height);
        else batch.draw(texture, x, y, width, height);
        font.setColor(textColor);
        float translateY = height / 2 - font.getCapHeight()/2;
        float translateX = width / 2 - text.length() * font.getCapHeight() / 2 / 1.4f;
        font.draw(batch, text, x + translateX, y + translateY);
    }
    public void press(float x, float y) {
        //TODO fix that
        if((x > this.x && x < this.x + width) && (y > this.y && y < this.y + height)) wasPressed = true;
        else wasPressed = false;
    }
    public boolean isClicked() {
        if(wasPressed && !Gdx.input.isTouched())
        {
            wasPressed = false;
            return true;
        }
        else return false;
    }
    public void changeTextures(Texture texture, Texture texture_pressed) {
        this.texture = texture;
        this.texture_pressed = texture_standard_pressed;
    }
    public CharSequence getText() {
        return text;
    }
    public void setText(CharSequence text) {
        this.text = text;
    }
}
