package de.buun.buga;

import de.buun.buga.command.world.WorldCommand;
import de.buun.buga.world.Categories;
import de.buun.uni.plugin.PluginData;
import de.buun.uni.plugin.UniversePlugin;

import java.io.File;

@PluginData(name = "BuildInGalaxy", authors = "Daver", version = "0.0.1")
public class BuildInGalaxy extends UniversePlugin {

    @Override
    public File setPluginFolder() {
        return null;
    }

    @Override
    public void onInitialisation() {
        new Categories();
        registerCommand(new WorldCommand());
    }

    @Override
    public void onTermination() {

    }
}
