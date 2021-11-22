package de.buun.buga;

import de.buun.buga.command.world.WorldCommand;
import de.buun.uni.world.Categories;
import de.buun.buga.world.CategoryTable;
import de.buun.buga.world.WorldTable;
import de.buun.uni.io.LanguageFile;
import de.buun.uni.plugin.PluginData;
import de.buun.uni.plugin.UniversePlugin;
import de.buun.uni.sql.database.SQLiteDatabase;

@PluginData(name = "BuildInGalaxy", authors = "Daver", version = "0.0.1")
public class BuildInGalaxy extends UniversePlugin {

    private static BuildInGalaxy instance;

    @Override
    public void onInitialisation() {
        instance = this;
        initDatabase();
        new Categories();
        registerCommand(new WorldCommand());
        this.languages.addLanguage(new LanguageFile(this.getPluginDir(), "en"));
        this.languages.addLanguage(new LanguageFile(this.getPluginDir(), "de"));
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
