package de.buun.buga.world;

import de.buun.buga.BuildInGalaxy;
import de.buun.uni.world.Category;
import de.buun.uni.world.World;
import de.buun.uni.world.WorldGenerator;

public class WorldCreationExectutor {

    private final String name;
    private final Category category;
    private final WorldGenerator generator;

    public WorldCreationExectutor(String name, Category category, WorldGenerator generator){
        this.name = name;
        this.category = category;
        this.generator = generator;
    }

    public World create(){
        WorldValueset world = new WorldValueset();
        world.setCategory(category);
        world.setName(name);
        world.setLoaded(true);
        world.setWorldGenerator(this.generator);
        world.setActiveVersion(0);
        world.setStopLag(true);
        world.setSymbol(category.getSymbol());
        generator.generate(world);
        WorldTable table = BuildInGalaxy.getInstance().getDatabase().getTable("worlds");
        table.addValues(world);
        category.addWorld(world);
        return world;
    }

}
