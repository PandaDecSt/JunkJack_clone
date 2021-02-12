package com.ansdoship.junkjack.world;

public class ItemGroup {
    String itemid;
    int numitem;

    public ItemGroup(String id, int num) {
        itemid = id;
        numitem = num;
    }
    
    public String getid(){
        return itemid;
    }
    
    public int getnum(){
        return numitem;
    }

}
