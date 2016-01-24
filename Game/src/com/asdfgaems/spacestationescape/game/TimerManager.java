package com.asdfgaems.spacestationescape.game;

import java.util.Vector;

public class TimerManager {
    public static Vector<Timer> timers;

    static {
        timers = new Vector<Timer>();
    }
    public static void addTimer(Timer timer) {
        timers.add(timer);
    }
    public static void removeTimer(Timer timer) {
        timers.remove(timer);
    }
    public static void update(float dt) {
        for(Timer t : timers) t.update(dt);
    }
}
