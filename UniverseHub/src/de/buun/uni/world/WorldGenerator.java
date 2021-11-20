package de.buun.uni.world;

public interface WorldGenerator {

    void setData(String[] data);
    String[] getData();

    int getId();

    void generate(World world);
}
