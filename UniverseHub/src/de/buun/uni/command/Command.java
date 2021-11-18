package de.buun.uni.command;


import de.buun.uni.UniverseException;
import de.buun.uni.command.annotations.*;
import de.buun.uni.entity.Console;
import de.buun.uni.entity.Entity;
import de.buun.uni.entity.User;
import de.buun.uni.log.Loggers;

import java.util.ArrayList;
import java.util.List;

public abstract class Command implements ICommand {

    protected final String name;
    protected final String permission;
    protected final int[] argRange;
    protected final String[] description;
    protected final List<Command> subCommands;
    protected final String[] aliases;

    protected boolean player;
    protected boolean console;
    protected int depth; //Zählt hoch wie weit der command verzweigt ist also an welcher stelle er steht

    public Command(){
        this.subCommands = new ArrayList<>();
        this.name = name();
        this.permission = permission();
        this.argRange = argRange();
        this.description = description();
        this.aliases = aliases();
        type();
    }

    @Override
    public List<Command> getSubCommands() {
        return this.subCommands;
    }

    @Override
    public void addSubCommand(Command command) {
        subCommands.add(command);
        command.depth = this.depth + 1;
    }

    @Override
    public void execute(Entity sender, String[] args) {
        if(runLonely(sender, args)) return;

        Command subCommand = getSubCommand(args);
        if(subCommand == null){
            run(sender, args);
            return;
        }

        String[] newArgs = trim(args, subCommand.depth);
        if(runChecks(subCommand, sender, newArgs)) return;
        subCommand.run(sender, newArgs);
    }

    private Command getSubCommand(String[] args){
        for(Command cmd : this.subCommands){
            if(checkName(args[cmd.depth], cmd)){
                Command subsubCommand = cmd.getSubCommand(args);
                if(subsubCommand != null){
                    return subsubCommand;
                }else{
                    return cmd;
                }
            }
        }
        return null;
    }

    private boolean checkName(String name, Command command){
        if(name.equalsIgnoreCase(command.name)) return true;
        for(String alias : command.aliases){
            if(alias.equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    private String[] trim(String[] args, int commandLength){
        int newLength = args.length - commandLength;
        if(newLength < 0) return new String[0];
        String[] newArgs = new String[newLength];
        System.arraycopy(args, commandLength - 1 , newArgs, 0 , newLength);
        return newArgs;
    }

    private void error(Entity entity, String path){

    }

    private boolean runChecks(Command command, Entity sender, String[] args){
        if(!player && sender instanceof User){
            error(sender, "command.fail.justconsole");
            return true;
        }
        if(!console && sender instanceof Console){
            error(sender, "command.fail.justplayer");
            return true;
        }

        if(args.length < command.argRange[0]){
            error(sender, "command.fail.args.missing");
            return true;
        }else if(args.length > command.argRange[1]){
            error(sender, "command.fail.args.toomany");
            return true;
        }

        if(!sender.hasPermission(command.permission)){
            error(sender, "command.fail.permission");
            return true;
        }

        return false;
    }

    private boolean runLonely(Entity sender, String[] args){
        if(args.length == 0){
            if(runChecks(this, sender, args)) return true;
            run(sender, args);
            return true;
        }
        return false;
    }

    private String name(){
        CommandName name = getClass().getAnnotation(CommandName.class);
        if(name == null){
            Loggers.log(new UniverseException("Command does not contain a name!"));
            return "";
        }
        return name.name();
    }

    private String permission(){
        CommandPermission perm = getClass().getAnnotation(CommandPermission.class);
        if(perm == null) return "";
        return perm.perm();
    }

    private int[] argRange(){
        ArgumentRange range = getClass().getAnnotation(ArgumentRange.class);
        if(range == null) return new int[2];
        return new int[]{range.min(), range.max()};
    }

    private void type(){
        PlayerCommand anno = getClass().getAnnotation(PlayerCommand.class);
        if(anno == null){
            this.player = true;
            this.console = true;
            return;
        }
        if(anno.player()){
            this.player = true;
        }else{
            this.console = true;
        }
    }

    private String[] description(){
        CommandDescription desc = getClass().getAnnotation(CommandDescription.class);
        if(desc == null) return new String[0];
        return desc.desc();
    }

    private String[] aliases(){
        CommandAliases aliases = getClass().getAnnotation(CommandAliases.class);
        if(aliases == null) return new String[0];
        return aliases.alias();

    }
}
