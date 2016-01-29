package com.asdfgaems.spacestationescape.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Wall extends GameObject {
    private static Texture texture = new Texture(Gdx.files.internal("wall1.png"));

    public Wall(Tile tile) {
        super(true, 4, tile);
    }

    public void draw(SpriteBatch batch, float x, float y) {
        batch.draw(texture, x, y, TileMap.tileSize, TileMap.tileSize);
    }

    public void update(float dt) {

    }
}