package com.asdfgaems.spacestationescape.game;

public class Timer {
    private float currentTime;
    private float maxTime;
    private boolean active;


    public Timer() {
        active = false;
        currentTime = 0.0f;
        maxTime = 0.0f;
    }
    public Timer(float maxTime) {
        active = false;
        currentTime = 0.0f;
        this.maxTime = maxTime;
    }
    public void update(float dt) {
        if(isActive()) currentTime += dt;
    }
    public void start() {
        active = true;
    }
    public void stop() {
        active = false;
        currentTime = 0.0f;
    }
    public void pause() {
        active = false;
    }
    public void changeMaxTime(float time) {
        maxTime = time;
    }
    public float getTime() {
        return currentTime;
    }
    public float getMaxTime() {
        return maxTime;
    }
    public boolean isEnded() {
        return currentTime >= maxTime;
    }
    public boolean isActive() {
        return active;
    }
}
