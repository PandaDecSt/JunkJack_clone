package com.ansdoship.junkjack.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.utils.TimeUtils;

public class ChunkGen {

    private static RandomXS128 rand;
    private static long seed;

    private static String[][] frontMap, backMap;
    static int[] hMap;

    public static long getSeed() {
        return seed;
    }

    private static void gentree(int x, int y) {
        backMap[x][y] = "wood";
        backMap[x][y + 1] = "wood";
        backMap[x][y + 2] = "wood";
        backMap[x][y + 3] = "wood";
        backMap[x][y + 4] = "leaves";
        backMap[x][y + 5] = "leaves";
        backMap[x + 1][y + 3] = "leaves";
        backMap[x + 1][y + 4] = "leaves";
        backMap[x - 1][y + 3] = "leaves";
        backMap[x - 1][y + 4] = "leaves";
        frontMap[x][y + 3] = "leaves";
        frontMap[x][y + 4] = "leaves";
        frontMap[x][y + 5] = "leaves";
        frontMap[x + 1][y + 3] = "leaves";
        frontMap[x + 1][y + 4] = "leaves";
        frontMap[x - 1][y + 3] = "leaves";
        frontMap[x - 1][y + 4] = "leaves";
    }

    static int[] genhMap(int width, int mid, int min, int max) {
        int[] res = new int[width];
        int t;
        res[0] = mid;
        for (int i=1; i < width; i++) {
            t = rand.nextInt(3) - 1;
            res[i] = res[i - 1] + t;
            if (res[i] < min) res[i] = min;
            if (res[i] > max) res[i] = max;
        }
        return res;
    }

    static void genChunk(int ChunkSize) {
        int dirtH;//土层高度
        int caveMaxH;
        int caveMinH;
        seed = TimeUtils.millis();
        rand = new RandomXS128(seed);
        frontMap = backMap = new String[ChunkSize][ChunkSize];
        hMap = genhMap(ChunkSize, ChunkSize / 2, ChunkSize / 4, ChunkSize / 4 * 3);
        for (int i = 0; i < ChunkSize; i++) {
            for (int j = 0; j < ChunkSize; j++) {
                frontMap[i][j] = backMap[i][j] = "air";
            }
        }
        for (int x=0; x < ChunkSize; x++) {
            dirtH = 4 + rand.nextInt(2);
            for (int y = 0; y < hMap[x]; y++) {
                if (y == hMap[x]) {
                    frontMap[x][y] = "dirt";
                    backMap[x][y] = "dirt";
                } else if (y >= hMap[x] - dirtH) {
                    frontMap[x][y] = "dirt";
                    backMap[x][y] = "dirt";
                } else if (y < hMap[x] - dirtH) {
                    frontMap[x][y] = "stone";
                    backMap[x][y] = "stone";
                }
                caveMaxH = hMap[x] - 3;
                caveMinH = hMap[x] - 6;
                if (y < caveMaxH && y > caveMinH) {
                    frontMap[x][y] = "air";
                    backMap[x][y] = "leaves";
                }
            }

            if (x > 2 && x < ChunkSize - 2 && rand.nextInt(100) < 5) gentree(x, hMap[x] - 1);
        }
    }

    static String[][] getfrontMap() {
        return frontMap;
    }

    static String[][] getBackMap() {
        return backMap;
    }

    static void clear() {
        frontMap = null;
        backMap = null;
    }
}
