package com.asdfgaems.spacestationescape.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Floor extends GameObject {
    private static Texture texture = new Texture(Gdx.files.internal("floor1.png"));

    public Floor(Tile tile) {
        super(false, 1, tile);
    }

    public void draw(SpriteBatch batch, float x, float y) {
        batch.draw(texture, x, y, TileMap.tileSize, TileMap.tileSize);
    }
    public void update(float dt) {

    }
}
