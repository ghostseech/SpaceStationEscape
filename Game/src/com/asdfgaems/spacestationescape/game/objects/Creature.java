package com.asdfgaems.spacestationescape.game.objects;

import com.asdfgaems.spacestationescape.game.Timer;
import com.asdfgaems.spacestationescape.game.TimerManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Creature extends GameObject {
    protected float health;
    protected float maxHealth;
    protected Timer walkTimer;
    protected World world;

    Creature(Tile tile, World world) {
        super(true, 5, tile);
        walkTimer = new Timer();
        TimerManager.addTimer(walkTimer);
        this.world = world;
    }

    public abstract void update(float dt);
    public abstract void draw(SpriteBatch batch, float x, float y);

    public void setWalkDelay(float delay) {
        walkTimer.changeMaxTime(delay);
    }
    public float getWalkDelay() {
        return walkTimer.getMaxTime();
    }
    public void damage(float damage) {
        health -= damage;
    }
    public float getHealth() {
        return health;
    }
    public float getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(float val) {
        maxHealth = val;
    }
    public void setHealth(float val) {
        health = val;
    }

    public boolean isDead() {
        return health <= 0.0f;
    }
}
