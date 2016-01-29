package com.asdfgaems.spacestationescape.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class FontManager {
    public static BitmapFont mainFont;
    public static Color interfaceTextColor = new Color(0.2f, 1.0f, 1.0f, 1.0f);
    public static Color interfaceColor = new Color(0.0f, 0.7f, 0.7f, 1.0f);
    public static void Init() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font1.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 128;
        parameter.flip = true;
        parameter.borderWidth = 5;
        parameter.genMipMaps = true;
        parameter.borderColor = interfaceColor;
        mainFont = generator.generateFont(parameter);
        generator.dispose();
    }
}
