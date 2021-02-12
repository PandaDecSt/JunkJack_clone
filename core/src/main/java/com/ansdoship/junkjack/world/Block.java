package com.ansdoship.junkjack.world;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Block extends Item{
    
    public boolean collision;

    public Block(String id, TextureRegion texture) {
        this(id, texture, true);
    }

    public Block(String id, TextureRegion texture, boolean collision) {
        super(id, texture);
        this.collision = collision;
    }

    public TextureRegion getTexture() {
        return texture;
    }
    
}
