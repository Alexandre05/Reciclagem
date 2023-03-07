package com.jogoreclicamaneco;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class GameScreen extends ScreenAdapter {

    private final SpriteBatch batch;
    private final OrthographicCamera camera;
    ;
    private final Texture background;
    private final Array<TrashCan> trashCans;
    private final Array<Trash> trashes;
    private final BitmapFont font;
    private float timeSinceLastTrash;
    private int score;
    private int coinCount;

    public GameScreen() {

        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false);
        background = new Texture("mv.png");
        trashCans = new Array<>();
        trashCans.addAll(
                new TrashCan(new Texture("lixeira.jpg"), 100, 100, TrashType.RECYCLABLE),
                new TrashCan(new Texture("cerveja.jpg"), 300, 100, TrashType.ORGANIC),
                new TrashCan(new Texture("lata.jpg"), 500, 100, TrashType.NON_RECYCLABLE)
        );
        trashes = new Array<>();
        font = new BitmapFont(Gdx.files.internal("assets/fonte.ttf"), Gdx.files.internal("assets/fonte.ttf"), false);

        init(0, 0);
    }

    public void init(int score, int coinCount) {
        this.score = score;
        this.coinCount = coinCount;
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta) {
        timeSinceLastTrash += delta;
        if (timeSinceLastTrash > 1f && MathUtils.random() < 0.01f) {
            createRandomTrash();
            timeSinceLastTrash = 0f;
        }
        moveTrashes(delta);
        checkCollisions();

    }

    private void draw() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        for (TrashCan trashCan : trashCans) {
            trashCan.draw(batch);
        }

        for (Trash trash : trashes) {
            trash.draw(batch);
        }

        font.draw(batch, "Score: " + score, 20, Gdx.graphics.getHeight() - 20);
        font.draw(batch, "Coins: " + coinCount, 20, Gdx.graphics.getHeight() - 50);

        batch.end();
    }

    private void createRandomTrash() {
        TrashType type = TrashType.values()[MathUtils.random(TrashType.values().length - 1)];
        Texture texture = new Texture(type.getTextureName());
        trashes.add(new Trash(texture, MathUtils.random(100, Gdx.graphics.getWidth() - 100), Gdx.graphics.getHeight(), type));
    }

    private void moveTrashes(float delta) {
        for (Trash trash : trashes) {

        }
    }

    private void checkCollisions() {
        for (Trash trash : trashes) {


    }


    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        for (TrashCan trashCan : trashCans) {
            trashCan.dispose();
        }
        for (Trash trash : trashes) {
           // trash.dispose();
        }
        font.dispose();
    }
}