package de.buun.uni.io;

import java.io.File;

public class ConfigurationFile extends ReadWriteFile{

    public ConfigurationFile(File dir, String name) {
        super(dir.getAbsolutePath() + "\\" + name + ".cfg");
    }

    public int getInt(String path){
        return Integer.parseInt(get(path));
    }

    public double getDouble(String path){
        return Double.parseDouble(get(path));
    }
}
