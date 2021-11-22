package de.buun.uni.spigot;

import de.buun.uni.BuildersUniverse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        BuildersUniverse.addUser(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        BuildersUniverse.removeUser(event.getPlayer().getUniqueId());
    }
}
