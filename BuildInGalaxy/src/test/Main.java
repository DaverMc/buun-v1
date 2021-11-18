package test;

import de.buun.buga.BuildInGalaxy;
import de.buun.buga.command.world.WorldCommand;

public class Main {

    public static void main(String[] args){
        BuildInGalaxy plugin = new BuildInGalaxy();
        plugin.onEnable();
        plugin.registerCommand(new WorldCommand());
    }

}
