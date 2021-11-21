package de.buun.buga.world;

import de.buun.uni.world.Category;
import de.buun.uni.world.gen.Generators;
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

    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public World setName(String name) {
        return null;
    }

    @Override
    public World setLoaded(boolean load) {
        setValue(2, fromBoolean(load));
        return this;
    }

    @Override
    public World setWorldGenerator(WorldGenerator generator) {
        setValue(4, generator.getId());
        setValue(5, fromArray(generator.getData()));
        return null;
    }

    @Override
    public World setActiveVersion(int version) {
        setValue(6, version);
        return this;
    }

    @Override
    public World setStopLag(boolean on) {
        setValue(3, fromBoolean(on));
        return this;
    }

    @Override
    public World setCategory(Category category){
        return this;
    }
}
