package com.jogoreclicamaneco;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Instrucao extends ScreenAdapter {
	private SpriteBatch batch;
	private Texture instructionTexture;
	private OrthographicCamera camera;
	private TelaDoJogo game;

	public Instrucao(TelaDoJogo game) {
		this.game = game;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		instructionTexture = new Texture("intrucao.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(instructionTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();

		if (Gdx.input.justTouched()) {
			//game.setScreen(new Nivel());
			dispose();
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		instructionTexture.dispose();
	}
}


