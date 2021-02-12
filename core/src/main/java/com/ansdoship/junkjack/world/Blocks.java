package com.ansdoship.junkjack.world;

import com.ansdoship.junkjack.world.Block;
import com.badlogic.gdx.utils.ArrayMap;

public class Blocks {
    
    public static ArrayMap<String, Block> BLOCKS = new ArrayMap<String, Block>();

    public static void put(String str, Block block) {
        BLOCKS.put(str, block);
    }
    
    public static Block get(String str) {
        return BLOCKS.get(str);
    }
    
}
