package com.asdfgaems.spacestationescape.desktop;


import com.asdfgaems.spacestationescape.game.SpaceStationEscape;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "SpaceStationEscape";
        config.width = 800;
        config.height = 480;
        new LwjglApplication(new SpaceStationEscape(), config);
    }
}
