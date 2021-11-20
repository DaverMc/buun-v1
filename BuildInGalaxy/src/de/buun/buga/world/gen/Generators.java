package de.buun.buga.world.gen;

import de.buun.uni.world.WorldGenerator;

public class Generators {

    public static WorldGenerator getGenerator(int id){
        return switch (id) {
            case 0 -> new VanillaWorldGenerator();
            case 1 -> new VoidWorldGenerator();
            default -> null;
        };
    }
}
