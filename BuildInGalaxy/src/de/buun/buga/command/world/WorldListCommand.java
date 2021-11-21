package de.buun.buga.command.world;

import de.buun.buga.BuildInGalaxy;
import de.buun.buga.collection.Permissions;
import de.buun.uni.command.Command;
import de.buun.uni.command.annotations.*;
import de.buun.uni.entity.Entity;
import de.buun.uni.entity.User;
import de.buun.uni.lang.MessageBuilder;

import java.util.Arrays;

@CommandName(name = "list")
@CommandAliases(alias = "l")
@ArgumentRange(max = 0)
@CommandPermission(perm = Permissions.COMMAND_WORLD_LIST)
@CommandDescription(desc = "Lists all commands that has to do with worlds")
public class WorldListCommand extends Command {

    public WorldListCommand() {
        super(BuildInGalaxy.getInstance());
    }

    @Override
    public void run(Entity entity, String[] args) {
        MessageBuilder builder = new MessageBuilder();
        new WorldCommand().getSubCommands().forEach(command -> {
            builder.add(command.getName() + " ");
            Arrays.asList(command.getDescription()).forEach(s ->
                builder.add(s).newLine()
            );
        });
        if(entity instanceof User) {
            builder.send((User) entity);
        }else{
            builder.console();
        }
    }
}
