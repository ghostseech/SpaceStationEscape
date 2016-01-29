package com.asdfgaems.spacestationescape.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileMap {
    public static final float tileSize = 96.0f;
    private int width;
    private int height;

    private Tile[][] tiles;

    public TileMap() {
        width = 120;
        height = 120;
        tiles = new Tile[120][120];
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                tiles[i][j] = new Tile(this, i, j);
            }
        }
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public void addObject(GameObject object, int x, int y) {
        if(x >= 0 && x < width && y >= 0 && y < height) {
            tiles[x][y].addObject(object);
        }
    }

    public void removeObject(GameObject object) {
        tiles[object.getX()][object.getY()].removeObject(object);
    }

    public void moveObject(GameObject object, int x, int y) {
        tiles[x][y].addObject(object);
        tiles[object.getX()][object.getY()].removeObject(object);
    }

    public void draw(SpriteBatch batch) {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                tiles[i][j].draw(batch, i * tileSize, j * tileSize);
            }
        }
    }
}
