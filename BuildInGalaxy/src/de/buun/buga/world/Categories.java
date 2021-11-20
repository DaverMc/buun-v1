package de.buun.buga.world;

import java.util.Map;

public class Categories {

    public static Categories instance;

    private Map<String, Category> categoryMap;

    public Categories(){
        instance = this;
    }

    public static void add(Category category){
        instance.categoryMap.put(category.name().toLowerCase(), category);
    }

    public static Category remove(String name){
        return instance.categoryMap.remove(name.toLowerCase());
    }

    public static Category get(String name){
        return instance.categoryMap.get(name.toLowerCase());
    }
}
