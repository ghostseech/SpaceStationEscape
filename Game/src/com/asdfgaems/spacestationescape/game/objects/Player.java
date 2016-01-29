package com.asdfgaems.spacestationescape.game.objects;

import com.asdfgaems.spacestationescape.game.InputHandler;
import com.asdfgaems.spacestationescape.game.Timer;
import com.asdfgaems.spacestationescape.game.TimerManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Creature {
    public static Texture texture = new Texture(Gdx.files.internal("player1.png"));
    float animX;
    float animY;
    private Timer moveAnimationTimer;

    Player(Tile tile, World world) {
        super(tile, world);
        maxHealth = 100.0f;
        health = 100.0f;
        setWalkDelay(0.3f);
        animX = 0.0f;
        animY = 0.0f;
        moveAnimationTimer = new Timer(0.3f);
        TimerManager.addTimer(moveAnimationTimer);
    }

    public void update(float dt) {
        int vecX = 0;
        int vecY = 0;
        if (InputHandler.isKeyDown(InputHandler.W)) vecY -= 1;
        if (InputHandler.isKeyDown(InputHandler.S)) vecY += 1;
        if (InputHandler.isKeyDown(InputHandler.A)) vecX -= 1;
        if (InputHandler.isKeyDown(InputHandler.D)) vecX += 1;
        if(!walkTimer.isActive()) {
            if(vecX != 0 || vecY != 0) {
                world.moveObject(this, this.getX() + vecX, this.getY() + vecY);
                walkTimer.start();
                animX = vecX * TileMap.tileSize;
                animY = vecY * TileMap.tileSize;
                moveAnimationTimer.start();
            }
        }
        if(walkTimer.isEnded()) walkTimer.stop();
        if(moveAnimationTimer.isEnded())moveAnimationTimer.stop();
    }

    public float getCamX() {
        return animX * moveAnimationTimer.getTime() / moveAnimationTimer.getMaxTime();
    }

    public float getCamY() {
        return animY * moveAnimationTimer.getTime() / moveAnimationTimer.getMaxTime();
    }

    public void draw(SpriteBatch batch, float x, float y) {
        if(moveAnimationTimer.isActive()) {
            System.out.println(animX * moveAnimationTimer.getTime() / moveAnimationTimer.getMaxTime() + "   " + animY * moveAnimationTimer.getTime() / moveAnimationTimer.getMaxTime());
            batch.draw(texture, x + animX * moveAnimationTimer.getTime() / moveAnimationTimer.getMaxTime(), y + animY * moveAnimationTimer.getTime() / moveAnimationTimer.getMaxTime(), TileMap.tileSize, TileMap.tileSize);
        }
        else batch.draw(texture, x, y, TileMap.tileSize, TileMap.tileSize);
    }
}
