package de.buun.uni.command;

import de.buun.uni.entity.Entity;

import java.util.List;

public interface ICommand {

    void run(Entity user, String[] args);

    void execute(Entity user, String[] args);

    List<Command> getSubCommands();

    void addSubCommand(Command command);
}
