package de.buun.uni.world.gen;

import de.buun.uni.version.VersionManager;
import de.buun.uni.version.v1_16.VoidWorldCreator16;
import de.buun.uni.version.v1_8.VoidWorldCreator8;
import de.buun.uni.world.World;
import de.buun.uni.world.WorldCreator;
import de.buun.uni.world.WorldGenerator;

public class VoidWorldGenerator implements WorldGenerator {

    private final WorldCreator creator;

    public VoidWorldGenerator(){
        this.creator = VersionManager.createInstance(WorldCreator.class, VoidWorldCreator8.class, VoidWorldCreator16.class);
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
        return 1;
    }

    @Override
    public void generate(World world) {
        creator.create(world);
    }
}
