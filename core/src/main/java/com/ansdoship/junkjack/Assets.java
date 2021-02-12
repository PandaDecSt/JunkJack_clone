package com.ansdoship.junkjack;

import com.ansdoship.junkjack.world.Block;
import com.ansdoship.junkjack.world.Blocks;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ArrayMap;

public class Assets {
    public static Sprite shadow;

    static TextureRegion[] blockTextures;

    public static ArrayMap<String, TextureRegion> heads = new ArrayMap<String, TextureRegion>();
    static TextureRegion[] headTextures;
    public static ArrayMap<String, TextureRegion> limbs = new ArrayMap<String, TextureRegion>();
    static TextureRegion[] limbTextures;
    public static ArrayMap<String, TextureRegion> beards = new ArrayMap<String, TextureRegion>();
    static TextureRegion[] beardTextures;

    public static void load() {
        loadBlocks();
        loadHumanAppearance();
    }

    public static void loadBlocks() {
        shadow = new Sprite(new Texture(Gdx.files.internal("images/tiles/shadow.png")));
        blockTextures = getTextureRegions("images/tiles/blocks.png", 32);

        Blocks.put("none", null);
        Blocks.put("air", new Block("air", blockTextures[0], false));
        Blocks.put("stone", new Block("stone", blockTextures[960]));
        Blocks.put("grass", new Block("grass", blockTextures[2502]));
        Blocks.put("dirt", new Block("dirt", blockTextures[2304]));
        Blocks.put("bedrock", new Block("bedrock", blockTextures[6]));
        Blocks.put("water", new Block("water", blockTextures[7], false));
        Blocks.put("lava", new Block("lava", blockTextures[8], false));
        Blocks.put("sand", new Block("sand", blockTextures[9]));
        Blocks.put("gravel", new Block("gravel", blockTextures[10]));
        Blocks.put("gold_ore", new Block("gold_ore", blockTextures[11]));
        Blocks.put("iron_ore", new Block("iron_ore", blockTextures[12]));
        Blocks.put("coal_ore", new Block("coal_ore", blockTextures[13]));
        Blocks.put("leaves", new Block("leaves", blockTextures[2312 - 64]));
        Blocks.put("wood", new Block("wood", blockTextures[2312]));
        Blocks.put("glass", new Block("glass", blockTextures[15]));
    }

    public static void loadHumanAppearance() {
        headTextures = getTextureRegions("images/tiles/head.png", 16);
        limbTextures = getTextureRegions("images/tiles/limb.png", 9);
        beardTextures = getTextureRegions("images/tiles/beard.png", 16);

        heads.put("man", headTextures[0]);
        heads.put("woman", headTextures[1]);

        beards.put("classic", beardTextures[0]);
        beards.put("japanese", beardTextures[1]);

        limbs.put("foot", limbTextures[0]);
        limbs.put("l_arm", limbTextures[1]);
        limbs.put("r_arm", limbTextures[2]);
        limbs.put("hand", limbTextures[4]);
    }

    public static TextureRegion[] getTextureRegions(String imgpath, int tilesize) {
        Texture img = new Texture(Gdx.files.internal(imgpath));
        int num = (img.getWidth() / tilesize) * (img.getHeight() / tilesize);
        TextureRegion[] tr = new TextureRegion[num];

        for (int i=0; i < num; i++) {
            tr[i] = new TextureRegion(img,
                                      (i % (img.getWidth() / tilesize)) * tilesize, (i / (img.getHeight() / tilesize)) * tilesize, tilesize, tilesize);
            tr[i].flip(false, true);
        }
        return tr;
    }

}
