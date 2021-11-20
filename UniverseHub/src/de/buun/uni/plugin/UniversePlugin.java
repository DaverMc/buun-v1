package de.buun.uni.plugin;

import de.buun.uni.command.Command;
import de.buun.uni.command.CommandRegistration;
import de.buun.uni.log.Level;
import de.buun.uni.log.Loggers;
import de.buun.uni.sql.Database;
import de.buun.uni.util.StopWatch;

import java.io.File;

public abstract class UniversePlugin {

    private File pluginDir;
    protected PluginData data;
    private CommandRegistration commandRegistration;
    protected Database database;

    public void onEnable(){
        this.data = getData();
        float millis = StopWatch.stopTime(this::initialise);
        Loggers.log(Level.INFO, "Plugin " + this.data.name() + "-v." + this.data.version() +" has successfully enabled in " + millis + "ms");
    }

    private void initialise(){
        this.pluginDir = setPluginFolder();
        this.commandRegistration = new CommandRegistration(this);
        onInitialisation();
    }

    public void onDisable(){
        float millis = StopWatch.stopTime(this::termination);
        Loggers.log(Level.INFO, "Plugin " + this.data.name() + " has successfully disabled in " + millis + "ms");
    }

    private void termination(){
        onTermination();
    }

    public File getPluginDir(){
        return this.pluginDir;
    }

    public void registerCommand(Command command){
        this.commandRegistration.register(command);
    }

    private PluginData getData(){
        PluginData data = this.getClass().getAnnotation(PluginData.class);
        if(data != null) return data;
        Loggers.log(Level.ERROR, "There is no PluginData annotated!");
        disable();
        return null;
    }

    public Database getDatabase(){
        return this.database;
    }

    public abstract File setPluginFolder();

    public abstract void onInitialisation();

    public abstract void onTermination();

    public void disable(){
        //Plugin disablen
    }
}
