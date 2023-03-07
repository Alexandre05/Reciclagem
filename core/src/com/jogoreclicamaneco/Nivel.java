package com.jogoreclicamaneco;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;


public class Nivel extends ScreenAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Game game;
	private ArrayList<Texture> levelTextures;
	private ArrayList<Integer> levelScores;
	private ArrayList<Integer> levelCoinCounts;
	private int currentLevel;

	public Nivel() {
		this.game = game;
		levelTextures = new ArrayList<Texture>();
		levelScores = new ArrayList<Integer>();
		levelCoinCounts = new ArrayList<Integer>();
		levelTextures.add(new Texture("nivel1.png"));
		levelScores.add(0);
		levelCoinCounts.add(0);
		levelTextures.add(new Texture("nivel2.jpg"));
		levelScores.add(500);
		levelCoinCounts.add(50);
		currentLevel = 0;

	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render ( float delta){
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(levelTextures.get(currentLevel), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();

		if (Gdx.input.justTouched()) {
			int score = levelScores.get(currentLevel);
			int coinCount = levelCoinCounts.get(currentLevel);
			//game.setScreen(new GameScreen(game, score, coinCount));
			dispose();
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		for (Texture texture : levelTextures) {
			texture.dispose();
		}
	}

	public void nextLevel () {
		currentLevel++;
		if (currentLevel >= levelTextures.size()) {
			//game.setScreen(new GameOverScreen(game, score, coinCount));
			dispose();
		}
	}
}
