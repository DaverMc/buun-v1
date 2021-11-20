package de.buun.buga.world.gen;

import de.buun.uni.world.World;
import de.buun.uni.world.WorldGenerator;

public class VoidWorldGenerator implements WorldGenerator {

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

    }
}
