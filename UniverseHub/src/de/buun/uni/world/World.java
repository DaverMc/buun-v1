package de.buun.uni.world;

import de.buun.uni.item.Item;

public interface World {

    String getName();

    boolean isStopLag();

    boolean isLoaded();

    WorldGenerator getGenerator();

    Item getSymbol();

    int getActiveVersion();

    Category getCategory();

    World setName(String name);

    World setLoaded(boolean load);

    World setWorldGenerator(WorldGenerator generator);

    World setActiveVersion(int version);

    World setStopLag(boolean on);

    World setCategory(Category category);
}
