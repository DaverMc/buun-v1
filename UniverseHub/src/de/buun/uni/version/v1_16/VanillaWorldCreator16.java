package de.buun.uni.version.v1_16;

import de.buun.uni.world.World;
import de.buun.uni.world.WorldCreator;
import org.bukkit.generator.ChunkGenerator;

public class VanillaWorldCreator16 extends ChunkGenerator implements WorldCreator {

    @Override
    public boolean create(World world) {
        org.bukkit.WorldCreator creator = new org.bukkit.WorldCreator(world.getName());
        return creator.createWorld() != null;
    }
}
