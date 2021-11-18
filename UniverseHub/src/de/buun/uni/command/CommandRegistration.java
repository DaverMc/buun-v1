package de.buun.uni.command;

import de.buun.uni.UniverseException;
import de.buun.uni.log.Loggers;
import de.buun.uni.plugin.UniversePlugin;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistration {

    private final Map<String, Command> commands;
    private final UniversePlugin plugin;

    public CommandRegistration(UniversePlugin plugin){
        this.plugin = plugin;
        this.commands = new HashMap<>();
    }

    public void register(Command command){
        if(commands.containsKey(command.name)){
            Loggers.log(new UniverseException("Command " + command.name + " is already registered!"));
            return;
        }
        commands.put(command.name, command);

        registerSpigot(command);
    }

    private void registerSpigot(Command command){

    }

}
