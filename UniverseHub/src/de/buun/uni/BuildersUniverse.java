package de.buun.uni;

import de.buun.uni.entity.Entity;
import de.buun.uni.entity.SimpleConsole;
import de.buun.uni.entity.SimpleUser;
import de.buun.uni.entity.User;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BuildersUniverse {

    private static final Map<UUID, User> userMap = new HashMap<>();

    public static void addUser(UUID uuid){
        userMap.put(uuid, new SimpleUser(uuid));
    }

    public static Player getSpigotPlayer(UUID uuid){
        return Bukkit.getPlayer(uuid);
    }

    public static void removeUser(UUID uuid){
        userMap.remove(uuid);
    }

    public static User getUser(UUID uuid){
        return userMap.get(uuid);
    }

    public static Entity fromCommandSender(CommandSender sender){
        if(sender instanceof Player){
            System.out.println(userMap.size());
            return getUser(((Player) sender).getUniqueId());
        }else{
            return new SimpleConsole();
        }
    }

}
