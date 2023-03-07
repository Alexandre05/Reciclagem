package com.jogoreclicamaneco;



import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Trash {

    private Texture texture;
    private float x;
    private float y;
    private float width;
    private float height;
    private TrashType type;

    public Trash(Texture texture, float x, float y, TrashType type) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.type = type;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public void update(float delta) {
        y -= 100 * delta; // Move o lixo para baixo
    }

    public float getY() {
        return y;
    }

    public float getHeight() {
        return height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public TrashType getType() {
        return type;
    }


}
