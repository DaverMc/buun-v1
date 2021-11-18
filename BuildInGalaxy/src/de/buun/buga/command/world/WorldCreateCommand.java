package de.buun.buga.command.world;

import de.buun.uni.command.Command;
import de.buun.uni.command.annotations.CommandAliases;
import de.buun.uni.command.annotations.CommandName;
import de.buun.uni.entity.Entity;

@CommandName(name = "create")
@CommandAliases(alias = "c")
public class WorldCreateCommand extends Command {
    @Override
    public void run(Entity user, String[] args) {

    }
}
