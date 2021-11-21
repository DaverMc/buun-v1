package de.buun.uni.world.gen;

import de.buun.uni.version.VersionManager;
import de.buun.uni.version.v1_16.VanillaWorldCreator16;
import de.buun.uni.version.v1_8.VanillaWorldCreator8;
import de.buun.uni.world.World;
import de.buun.uni.world.WorldCreator;
import de.buun.uni.world.WorldGenerator;

public class VanillaWorldGenerator implements WorldGenerator {

    private final WorldCreator creator;

    public VanillaWorldGenerator(){
        this.creator = VersionManager.createInstance(WorldCreator.class, VanillaWorldCreator8.class, VanillaWorldCreator16.class);
    }

    @Override
    public void setData(String[] data) {

    }

    @Override
    public String[] getData() {
        return new String[0];
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void generate(World world) {
        creator.create(world);
    }
}
