package de.buun.uni.version.v1_16;

import de.buun.uni.BuildersUniverse;
import de.buun.uni.command.Command;
import de.buun.uni.command.CommandRegistrator;
import de.buun.uni.entity.Entity;
import de.buun.uni.log.Level;
import de.buun.uni.log.Loggers;
import de.buun.uni.util.Reflections;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.Arrays;
import java.util.List;

public class CommandRegistrator16 implements CommandRegistrator {

    @Override
    public void register(Command command) {
        CommandMap commandMap = Reflections.getValue(Bukkit.getServer(), "commandMap");
        if(commandMap == null) return;
        List<String> alias = Arrays.asList(command.getAliases());
        org.bukkit.command.Command bukkitCommand = new BukkitCommand(command.getName(), "a Builders Universe Command!", "/usage", alias) {
            @Override
            public boolean execute(CommandSender commandSender, String s, String[] strings) {
                Entity sender = BuildersUniverse.fromCommandSender(commandSender);
                command.execute(sender, strings);
                return true;
            }
        };
        commandMap.register(command.getName(), bukkitCommand);
        Loggers.log(Level.INFO, "Registered command: " + command.getName());
    }
}
