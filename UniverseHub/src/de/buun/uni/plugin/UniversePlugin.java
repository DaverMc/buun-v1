package de.buun.uni.plugin;

import de.buun.uni.BuildersUniverse;
import de.buun.uni.command.Command;
import de.buun.uni.command.CommandRegistration;
import de.buun.uni.lang.Languages;
import de.buun.uni.log.Level;
import de.buun.uni.log.Loggers;
import de.buun.uni.spigot.JoinQuitListener;
import de.buun.uni.sql.Database;
import de.buun.uni.util.StopWatch;
import javafx.util.Builder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public abstract class UniversePlugin extends JavaPlugin {

    protected PluginData data;
    private CommandRegistration commandRegistration;
    protected Database database;
    protected Languages languages;

    @Override
    public void onEnable(){
        this.data = getData();
        Bukkit.getOnlinePlayers().forEach(p -> BuildersUniverse.addUser(p.getUniqueId()));
        Bukkit.getPluginManager().registerEvents(new JoinQuitListener(), this);
        float millis = StopWatch.stopTime(this::initialise);
        Loggers.log(Level.INFO, "Plugin " + this.data.name() + "-v." + this.data.version() +" has successfully enabled in " + millis + "ms");
    }

    private void initialise(){
        this.commandRegistration = new CommandRegistration(this);
        this.languages = new Languages();
        onInitialisation();
    }

    @Override
    public void onDisable(){
        float millis = StopWatch.stopTime(this::termination);
        Loggers.log(Level.INFO, "Plugin " + this.data.name() + " has successfully disabled in " + millis + "ms");
    }

    private void termination(){
        onTermination();
    }

    public File getPluginDir(){
        return this.getDataFolder();
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

    public Languages getLanguages(){
        return this.languages;
    }

    public Database getDatabase(){
        return this.database;
    }

    public abstract void onInitialisation();

    public abstract void onTermination();

    public void disable(){
        Bukkit.getPluginManager().disablePlugin(this);
    }
}
