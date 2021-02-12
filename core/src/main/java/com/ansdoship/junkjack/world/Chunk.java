package com.ansdoship.junkjack.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ansdoship.junkjack.Assets;

public class Chunk {

    private String[][] frontMap;
    private String[][] backMap;
    public static int ChunkSize = 64;
    public static int tilesize = 32;
    public static int TileWidth = tilesize, TileHeight = tilesize;
    public int wx, wy;
    TextureRegion nullt = 
    new TextureRegion(new Texture("null.png"));

    public Chunk(int x, int y) {

        ChunkGen.genChunk(ChunkSize);
        frontMap = ChunkGen.getfrontMap();
        backMap = ChunkGen.getBackMap();
        ChunkGen.clear();
        wx = x;
        wy = y;

    }

    public TextureRegion getfrontMap(int x, int y) {
        if (Blocks.BLOCKS.containsKey(frontMap[x][y]))
            return Blocks.get(frontMap[x][y]).getTexture();
        else return null;
    }

    public void setfrontMap(int x, int y, String id) {
        frontMap[x][y] = id;
    }

    public TextureRegion getbackMap(int x, int y) {
        if (Blocks.BLOCKS.containsKey(backMap[x][y]))
            return Blocks.get(backMap[x][y]).getTexture();
        else return null;
    }

    public void setbackMap(int x, int y, String id) {
        backMap[x][y] = id;
    }

    public void draw(World world) {
        draw(world, wx, wy);
    }

    public void draw(World world, int x, int y) {
        for (int i = 0; i < ChunkSize; i++) {
            for (int j = 0; j < ChunkSize; j++) {
                int sx = i * TileWidth;
                int sy = j * TileHeight;
                if (getfrontMap(i, j) != null | frontMap[i][j] != "air") {
                    world.draw(getfrontMap(i, j), sx + x, sy + y, TileWidth, TileHeight);
                } else
                if (getbackMap(i, j) != null | backMap[i][j] != "air") {
                    world.draw(getbackMap(i, j), sx + x, sy + y, TileWidth, TileHeight);
                    //world.draw(nullt, sx + x, sy + y, TileWidth, TileHeight);
                    Assets.shadow.setPosition(sx + x, sy + y);
                    Assets.shadow.draw(world);
                }
                
//                if (getfrontMap(i, j) == null | frontMap[i][j] == "air") {
//                    world.draw(Assets.shadow, sx + x, sy + y, TileWidth, TileHeight);
////                    Assets.shadow.setPosition(sx + x, sy + y);
////                    Assets.shadow.draw(world);
//                }
            }
        }
    }

}
