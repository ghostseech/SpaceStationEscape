package com.asdfgaems.spacestationescape.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject {
    public static final int ITEM = 1;
    public static final int CREATURE = 2;
    public static final int TERRAIN = 3;

    private boolean collidable;
    private int drawPriority;
    protected Tile tile;

    public abstract void update(float dt);
    public abstract void draw(SpriteBatch batch, float x, float y);

    public GameObject(boolean collidable, int drawPriority, Tile tile) {
        this.collidable = collidable;
        this.drawPriority = drawPriority;
        this.tile = tile;
    }

    public void changeTile(Tile tile) {
        this.tile = tile;
    }
    public int getX() {
        return tile.getX();
    }
    public int getY() {
        return tile.getY();
    }

    public int getDrawPriority() {
        return drawPriority;
    }

    public boolean isCollidable() {
        return collidable;
    }
}
