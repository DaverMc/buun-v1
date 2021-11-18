package de.buun.uni.item;

import de.buun.uni.collection.ItemType;

import java.util.Arrays;
import java.util.List;

public class Item {

    private final ItemType itemType;
    private IItem<?> itemVI;
    private String name;
    private boolean glowing;
    private List<String> lore;

    public Item(ItemType type){
        this.itemType = type;
    }

    public Item setName(String name){
        this.name = name;
        return this;
    }

    public Item setGlowing(boolean glowing){
        this.glowing = glowing;
        return this;
    }

    public Item setLoreLine(int index, String text){
        if(index < lore.size()){
            this.lore.add(index, text);
        }else{
            for(int i = lore.size() - 1; i < index -1; i++){
                this.lore.add("");
            }
            this.lore.add(text);
        }
        return this;
    }

    public Item addLore(String...text){
        this.lore.addAll(Arrays.asList(text));
        return this;
    }

    public <T> T toStack(){
        return (T) this.itemVI.toMinecraftStack(this);
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public List<String> getLore() {
        return lore;
    }

    public boolean isGlowing() {
        return glowing;
    }
}
