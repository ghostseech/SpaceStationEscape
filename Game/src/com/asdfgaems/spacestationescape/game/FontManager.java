package com.asdfgaems.spacestationescape.game;

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class FontManager {
    public static BitmapFont mainFont;

    public static void Init() {

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font1.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 128;
        parameter.flip = true;
        parameter.genMipMaps = true;
        mainFont = generator.generateFont(parameter);
        generator.dispose();
    }
}
