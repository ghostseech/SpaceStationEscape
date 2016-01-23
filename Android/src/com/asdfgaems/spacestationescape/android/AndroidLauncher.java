package com.asdfgaems.spacestationescape.android;

import android.os.Bundle;
import com.asdfgaems.spacestationescape.game.SpaceStationEscape;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;


public class AndroidLauncher extends AndroidApplication{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config= new AndroidApplicationConfiguration();
        initialize(new SpaceStationEscape(), config);
    }
}
