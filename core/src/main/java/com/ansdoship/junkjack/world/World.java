package com.ansdoship.junkjack.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.ansdoship.junkjack.util.Constant;
import com.badlogic.gdx.math.Matrix4;

public class World extends SpriteBatch {
    public int ChunkRenderingDistance;
    public Chunk[][] chunks;
    Texture skytexture;
    SpriteBatch sky;
//    public ArrayList<ArrayList<Chunk>> chunks = new ArrayList<>();
    public int width, height;

    /*
     *      向外延长n 2n+1为边长
     *                    □ □ □ □ □
     *       □ □ □       □ □ □ □ □
     * □ +1  □ □ □  +1   □ □ □ □ □
     *       □ □ □       □ □ □ □ □
     *                    □ □ □ □ □
     */

    public World(int ChunkRenderingDistance) {
        super();
        sky = new SpriteBatch();
        skytexture = new Texture("images/tiles/sky/sky-terra-day-low.png");
        this.ChunkRenderingDistance = ChunkRenderingDistance;
        width = height = ChunkRenderingDistance * 2 + 1;
//        for (int j = 0; j < height; j++) {
//            ArrayList<Chunk> chunkline = new ArrayList<>();
//            for (int i = 0; i < width; i++) {
//                chunkline.add(new Chunk());
//            }
//            chunks.add(chunkline);
//        }

        chunks = new Chunk [width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                chunks[i][j] = new Chunk(i, j);
            }
		}
    }

    public void setSky(Texture skytexture) {
        this.skytexture = skytexture;
    }

    public Texture getSky() {
        return skytexture;
    }

    public Chunk getChunk(int x, int y) {
        return chunks[x][y];//chunks.get(y).get(x);
    }

    public void draw(Matrix4 m) {
//        getChunk(0, 0).draw(this, 0, 0);
//        getChunk(0, 1).draw(this, 0, 256);
//        getChunk(0, 2).draw(this, 0, 512);
//        getChunk(1, 0).draw(this, 256, 0);
//        getChunk(1, 1).draw(this, 256, 256);
//        getChunk(1, 2).draw(this, 256, 512);
//        getChunk(2, 0).draw(this, 512, 0);
//        getChunk(2, 1).draw(this, 512, 256);
//        getChunk(2, 2).draw(this, 512, 512);
        setProjectionMatrix(m);
        sky.setProjectionMatrix(m);
        sky.begin();
        sky.draw(skytexture, 0, 0, Constant.screenWidth, Constant.screenHeight);
        sky.end();
        for (int i = 0; i < width; i++) {
            int sx = i * Chunk.TileWidth * Chunk.ChunkSize;
            for (int j = 0; j < height; j++) {
                int sy = j * Chunk.TileHeight * Chunk.ChunkSize;
                getChunk(i, j).draw(this, sx, sy);
                Gdx.app.log("drawChunk", String.format("x:%d y:%d", sx, sy));
            }
        }
    }

}
