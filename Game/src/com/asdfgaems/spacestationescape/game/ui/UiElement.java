package com.asdfgaems.spacestationescape.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class UiElement {
    protected float x;
    protected float y;
    protected Color color;


    public UiElement(float x, float y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public Vector2 getPosition() {
        return new Vector2(x,y);
    }
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void draw(SpriteBatch batch) {
        batch.setColor(color);
        drawElement(batch);
    }
    public abstract void drawElement(SpriteBatch batch);
}
