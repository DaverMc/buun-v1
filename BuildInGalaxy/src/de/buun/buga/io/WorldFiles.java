package de.buun.buga.io;

import java.io.File;

public class WorldFiles {

    private static WorldFiles instance;

    private final File worldContainer;
    private final File importDir;
    private final File exportDir;
    private final File categoryDir;

    public WorldFiles(File worldContainer, File importDir, File exportDir, File categoryDir){
        this.worldContainer = worldContainer;
        this.importDir = importDir;
        this.exportDir = exportDir;
        this.categoryDir = categoryDir;
    }

    public static File getWorldContainer(){
        return instance.worldContainer;
    }

    public static File getImportDir(){
        return instance.importDir;
    }

    public static File getExportDir(){
        return instance.exportDir;
    }

    public static File getCategoryDir(){
        return instance.categoryDir;
    }
}
