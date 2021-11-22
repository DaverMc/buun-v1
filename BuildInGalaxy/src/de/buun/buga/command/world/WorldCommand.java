package de.buun.buga.command.world;

import de.buun.buga.BuildInGalaxy;
import de.buun.buga.collection.Permissions;
import de.buun.uni.command.Command;
import de.buun.uni.command.annotations.*;
import de.buun.uni.entity.Entity;

@CommandName(name = "world")
@CommandAliases(alias = {"w", "welt"})
@CommandPermission(perm = Permissions.COMMAND_WORLD)
@ArgumentRange(max = 0)
@CommandDescription(desc = {"This command does everything that has to do with worlds"})
public class WorldCommand extends Command {

    public WorldCommand(){
        super(BuildInGalaxy.getInstance());
        this.addSubCommand(new WorldCreateCommand());
        this.addSubCommand(new WorldListCommand());
    }

    @Override
    public void run(Entity user, String[] args) {

    }
}
