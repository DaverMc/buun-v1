package de.buun.buga.world;

import de.buun.buga.world.gen.Generators;
import de.buun.uni.item.Item;
import de.buun.uni.sql.internal.Valueset;
import de.buun.uni.world.World;
import de.buun.uni.world.WorldGenerator;

public class WorldValueset extends Valueset implements World {

    public WorldValueset(){
        super(8); // Anzahl der Columns des WorldTables
    }

    @Override
    public String getName() {
        return get(1);
    }

    @Override
    public boolean isStopLag() {
        return getBoolean(get(3));
    }

    @Override
    public boolean isLoaded() {
        return getBoolean(get(2));
    }

    @Override
    public WorldGenerator getGenerator() {
        WorldGenerator generator = Generators.getGenerator(get(4));
        generator.setData(getArray(get(5)));
        return generator;
    }

    @Override
    public Item getSymbol() {
        return Item.deserialize(get(7));
    }

    @Override
    public int getActiveVersion() {
        return get(6);
    }
}
