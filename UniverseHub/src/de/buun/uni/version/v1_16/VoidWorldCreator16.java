package de.buun.uni.version.v1_16;

import de.buun.uni.util.ArrayIterator;
import de.buun.uni.world.World;
import de.buun.uni.world.WorldCreator;
import org.bukkit.Material;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class VoidWorldCreator16 extends ChunkGenerator implements WorldCreator {

    @Override
    public boolean create(World world) {
        org.bukkit.WorldCreator creator = new org.bukkit.WorldCreator(world.getName());
        creator.generator(this);
        creator.type(WorldType.FLAT);
        return creator.createWorld() != null;
    }



    @Override
    public ChunkGenerator.ChunkData generateChunkData(org.bukkit.World world, Random random, int chunkX, int chunkZ, ChunkGenerator.BiomeGrid biome) {
        ChunkGenerator.ChunkData data = createChunkData(world);
        ArrayIterator.forIndex(16, x ->
            ArrayIterator.forIndex(16, y ->{
                data.setBlock(x, 0 , y, Material.AIR);
                biome.setBiome(x, 0, y, Biome.PLAINS);
            })
        );
        return data;
    }
}
