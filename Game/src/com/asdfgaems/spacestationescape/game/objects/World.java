package com.asdfgaems.spacestationescape.game.objects;

import com.asdfgaems.spacestationescape.game.InputHandler;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Vector;

public class World {
    private TileMap tileMap;
    private Vector<GameObject> objects;

    private GameObject playerObject;
    private float camX;
    private float camY;

    public World() {
        objects = new Vector<GameObject>();
        tileMap = new TileMap();
    }

    public void init() {
        generate();
    }

    private void generate() {
        Player p = new Player(tileMap.getTile(4, 4), this);
        playerObject = p;
        addObject(p, 4, 4);
        for(int i = 0; i < 120; i++) {
            for(int j = 0; j < 120; j++) {
                Floor f = new Floor(tileMap.getTile(i, j));
                addObject(f, i, j);
            }
        }
        for(int x = 0; x < 120; x++) {
            for(int y = 0; y < 120; y++) {
                if(x==0 || (x > 0 && x < 119 && (y == 0 || y == 119)) || x == 119  ) {
                    Wall w = new Wall(tileMap.getTile(x, y));
                    addObject(w, x, y);
                }
            }
        }
    }

    public void moveObject(GameObject object, int x, int y) {
        tileMap.moveObject(object, x, y);
        object.changeTile(tileMap.getTile(x, y));
    }

    public void addObject(GameObject object, int x, int y) {
        tileMap.addObject(object, x, y);
        objects.add(object);
    }

    public void removeObject(GameObject object) {
        tileMap.removeObject(object);
        objects.remove(object);
    }

    public void draw(SpriteBatch batch) {
        tileMap.draw(batch);
    }

    public float getCamX() {
        if(playerObject != null) return playerObject.getX() * TileMap.tileSize + ((Player)playerObject).getCamX();
        else return 0;
    }

    public float getCamY() {
        if(playerObject != null) return playerObject.getY() * TileMap.tileSize + ((Player)playerObject).getCamY();
        else return 0;
    }
    public void update(float dt) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update(dt);
        }
    }
}
