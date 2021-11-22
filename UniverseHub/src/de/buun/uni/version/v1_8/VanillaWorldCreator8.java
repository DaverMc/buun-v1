package de.buun.uni.version.v1_8;

import de.buun.uni.world.World;
import de.buun.uni.world.WorldCreator;

public class VanillaWorldCreator8 implements WorldCreator {
    @Override
    public boolean create(World world) {
        org.bukkit.WorldCreator creator = new org.bukkit.WorldCreator(world.getName());
        return creator.createWorld() != null;
    }
}
