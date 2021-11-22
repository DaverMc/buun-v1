package de.buun.uni.world.gen;

import de.buun.uni.world.WorldGenerator;

public class Generators {

    public static WorldGenerator getGenerator(int id){
        switch (id) {
            case 0 : return new VanillaWorldGenerator();
            case 1 : return new VoidWorldGenerator();
            default : return null;
        }
    }
}
