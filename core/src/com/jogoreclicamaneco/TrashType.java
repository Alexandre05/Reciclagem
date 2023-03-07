package com.jogoreclicamaneco;

public enum TrashType {
    RECYCLABLE("recyclable.png"),
    ORGANIC("organic.png"),
    NON_RECYCLABLE("nonrecyclable.png");

    private String textureName;

    private TrashType(String textureName) {
        this.textureName = textureName;
    }

    public String getTextureName() {
        return textureName;
    }
}

