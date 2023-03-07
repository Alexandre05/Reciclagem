package com.jogoreclicamaneco;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class Assets {
    private HashMap<String, Texture> textures;

    public Assets() {
        textures = new HashMap<String, Texture>();
    }

    public Texture getTexture(String path) {
        if (!textures.containsKey(path)) {
            textures.put(path, new Texture(path));
        }
        return textures.get(path);
    }

    public void dispose() {
        for (Texture texture : textures.values()) {
            texture.dispose();
        }
    }

}
