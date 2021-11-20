package de.buun.uni.world;

import de.buun.uni.item.Item;

public interface World {

    String getName();

    boolean isStopLag();

    boolean isLoaded();

    WorldGenerator getGenerator();

    Item getSymbol();

    int getActiveVersion();




}
