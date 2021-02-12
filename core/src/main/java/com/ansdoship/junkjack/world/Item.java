package com.ansdoship.junkjack.world;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Item {
    String id;
    TextureRegion texture;

    public Item(String id, TextureRegion texture) {
        this.id = id;
        this.texture = texture;
    }

    public String getid() {
        return id;
    }
    
    public void setid(String id){
        this.id = id;
    }

    public TextureRegion getTexture() {
        return texture;
    }
}
