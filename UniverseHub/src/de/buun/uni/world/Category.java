package de.buun.uni.world;

import de.buun.uni.item.Item;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Category {

    private final String name;
    private final List<World> worlds;
    private final File dir;
    private Item symbol;
    private int highestId;

    public Category(String name, File dir){
        this.name = name;
        this.worlds = new ArrayList<>();
        this.dir = dir;
    }

    public Category setSymbol(Item item){
        this.symbol = item;
        return this;
    }

    public void addWorld(World world){
        if(world.getId() == -1) {
            highestId++;
            world.setId(highestId);
        }
        this.worlds.add(world);
    }

    public List<World> getWorlds(){
        return this.worlds;
    }

    public Item getSymbol(){
        return this.symbol;
    }

    public String name(){
        return this.name;
    }

    public File getDir(){
        return this.dir;
    }

}
