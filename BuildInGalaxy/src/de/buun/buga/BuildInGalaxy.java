package de.buun.buga;

import de.buun.buga.command.world.WorldCommand;
import de.buun.buga.world.Categories;
import de.buun.buga.world.CategoryTable;
import de.buun.buga.world.WorldTable;
import de.buun.uni.plugin.PluginData;
import de.buun.uni.plugin.UniversePlugin;
import de.buun.uni.sql.database.SQLiteDatabase;

import java.io.File;

@PluginData(name = "BuildInGalaxy", authors = "Daver", version = "0.0.1")
public class BuildInGalaxy extends UniversePlugin {

    private static BuildInGalaxy instance;

    @Override
    public File setPluginFolder() {
        return null;
    }

    @Override
    public void onInitialisation() {
        instance = this;
        initDatabase();
        new Categories();
        registerCommand(new WorldCommand());
    }

    @Override
    public void onTermination() {

    }

    public static BuildInGalaxy getInstance(){
        return instance;
    }

    private void initDatabase(){
        database = new SQLiteDatabase(getPluginDir().getAbsolutePath() + "data.db");
        new WorldTable(database);
        new CategoryTable(database);
    }
}
