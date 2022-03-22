package com.star.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.star.app.game.GameController;
import com.star.app.game.WorldRenderer;
import com.star.app.screen.utils.Assets;

public class GameScreen extends AbstractScreen{

    private GameController gc;
    private WorldRenderer worldRenderer;
    private Boolean pause = true;

    public GameScreen(SpriteBatch batch) {
        super(batch);
    }

    public GameController getGc() {
        return gc;
    }

    public Boolean getPause() {
        return pause;
    }

    @Override
    public void show() {
        Assets.getInstance().loadAssets(ScreenManager.ScreenType.GAME);
        this.gc = new GameController(this);
        this.worldRenderer = new WorldRenderer(gc, batch);
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            pause = !pause;
        }
        if (pause) {
            gc.update(delta);
        }
        worldRenderer.render();
    }
}
