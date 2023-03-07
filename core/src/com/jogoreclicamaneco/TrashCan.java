package com.jogoreclicamaneco;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class TrashCan {

        private List<String> trash; // lista de lixo

        // construtor da classe
        public TrashCan(Texture texture, int i, int i1, TrashType recyclable) {
            trash = new ArrayList<>();
        }

        // adiciona um item na lixeira
        public void addTrash(String item) {
            trash.add(item);
        }

        // esvazia a lixeira
        public void emptyTrash() {
            trash.clear();
        }

        // retorna a lista de itens na lixeira
        public List<String> getTrash() {
            return trash;
        }

    public void dispose() {
    }

    public void draw(SpriteBatch batch) {
    }
}


