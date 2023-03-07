package com.jogoreclicamaneco;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen extends ScreenAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Game game;
	private BitmapFont font;

	public GameOverScreen(Game game, int score, int coinCount) {
		this.game = game;
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.getData().setScale(2);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		font.draw(batch, "Game Over!", Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 + 50);
		font.draw(batch, "Tap to play again", Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2);
		batch.end();

		if (Gdx.input.justTouched()) {
			game.setScreen(new Nivel());
			dispose();
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}