package com.ansdoship.junkjack.world;

import com.badlogic.gdx.utils.ArrayMap;

public class Player {
    
    public final ItemGroup[] inventory;
    public int slotsize = 42;
    int gamemode;
    int x, y;
    
    public Player(){
        inventory = new ItemGroup[slotsize];
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setGamemode(int gamemode) {
        this.gamemode = gamemode;
    }

    public int getGamemode() {
        return gamemode;
    }
    
    public void draw(World world){
        
    }
    
}
