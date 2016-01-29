package com.asdfgaems.spacestationescape.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Vector;

public class Tile {
    private TileMap tileMap;
    private Vector<GameObject> gameObjects;
    private int x;
    private int y;

    Tile(TileMap tileMap, int x, int y) {
        gameObjects = new Vector<GameObject>();
        this.tileMap = tileMap;
        this.x = x;
        this.y = y;
    }

    public void addObject(GameObject object) {
        if(gameObjects.size() > 0) {
            for(int i = 0; i < gameObjects.size(); i++) {
                if(gameObjects.get(i).getDrawPriority() > object.getDrawPriority()) {
                    gameObjects.add(i, object);
                    System.out.println(gameObjects.firstElement() + "   " + gameObjects.lastElement());
                    return;
                }
            }
            gameObjects.add(object);
        }
        else gameObjects.add(object);
    }

    public void removeObject(GameObject object) {
        gameObjects.remove(object);
    }

    public void draw(SpriteBatch batch, float x, float y) {
        if(gameObjects.size() >= 2) {
        }
        for(int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).draw(batch, x, y);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCollidable() {
        return false;
    }
}
