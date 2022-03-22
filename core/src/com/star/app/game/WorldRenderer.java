package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.star.app.screen.utils.Assets;

public class WorldRenderer {
    private GameController gc;
    private SpriteBatch batch;
    private BitmapFont font32;
    private BitmapFont font72;
    private StringBuilder sb;

    public WorldRenderer(GameController gc, SpriteBatch batch) {
        this.gc = gc;
        this.batch = batch;
        this.font32 = Assets.getInstance().getAssetManager().get("fonts/font32.ttf");
        this.font72 = Assets.getInstance().getAssetManager().get("fonts/font72.ttf");
        this.sb = new StringBuilder();
    }

    public void render () {
        ScreenUtils.clear(0, 0, 0.5f, 1);
        batch.begin();
        gc.getBackground().render(batch);
        gc.getBulletController().render(batch);
        gc.getAsteroidController().render(batch);
        gc.getParticleController().render(batch);
        gc.getPowerUpsController().render(batch);
        gc.getHero().render(batch);
        gc.getHero().renderGUI(batch, font32);
        if(!gc.getGameScreen().getPause()) {
            gc.pause(batch, font72);
        }
        batch.end();
    }
}
