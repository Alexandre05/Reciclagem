package com.jogoreclicamaneco;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.ScreenUtils;

public class TelaDoJogo extends ApplicationAdapter {
	// Declaração das variáveis
	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 480;

	private Assets assets;
	private GameScreen gameScreen;
	private Nivel levelScreen;
	private Instrucao instructionScreen;
	private SplashScreen splashScreen;

	private Game game; // Adiciona uma variável do tipo Game

	public TelaDoJogo() { // Adiciona um construtor que recebe um objeto do tipo Game
		this.game = game;
	}

	@Override
	public void create () {
		assets = new Assets();
		gameScreen = new GameScreen();
		levelScreen = new Nivel();
		instructionScreen = new Instrucao(this);
		splashScreen = new SplashScreen(this);

		setScreen(gameScreen); // Chama o método setScreen passando o objeto gameScreen como argumento
	}

	private void setScreen(GameScreen screen) {
		game.setScreen(screen); // Coloca a tela na variável de jogo
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
	}

	@Override
	public void dispose () {

	}
}
