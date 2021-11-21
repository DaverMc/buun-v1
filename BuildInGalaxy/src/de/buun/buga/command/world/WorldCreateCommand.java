package de.buun.buga.command.world;

import de.buun.buga.BuildInGalaxy;
import de.buun.buga.world.Categories;
import de.buun.buga.world.Category;
import de.buun.uni.command.Command;
import de.buun.uni.command.annotations.ArgumentRange;
import de.buun.uni.command.annotations.CommandAliases;
import de.buun.uni.command.annotations.CommandName;
import de.buun.uni.entity.Console;
import de.buun.uni.entity.Entity;
import de.buun.uni.entity.User;
import de.buun.uni.lang.MessageBuilder;
import de.buun.uni.math.Maths;
import de.buun.uni.plugin.UniversePlugin;
import de.buun.uni.world.WorldGenerator;
import de.buun.uni.world.gen.Generators;

/*
* /world create category name genid genData
 */

@CommandName(name = "create")
@CommandAliases(alias = "c")
@ArgumentRange(min = 3, max = 4)
public class WorldCreateCommand extends Command {

    public WorldCreateCommand() {
        super(BuildInGalaxy.getInstance());
    }

    @Override
    public void run(Entity entity, String[] args) {
        Category category = Categories.get(args[0]);
        if(category == null){
            this.message(entity, "command.world.create.fail.category", args[0]);
            return;
        }

        String name = args[1];

        int[] genId = Maths.fromString(args[2]);
        if(genId.length == 2){
            this.message(entity, "command.world.create.fail.genId", args[2]);
            return;
        }
        WorldGenerator gen = Generators.getGenerator(genId[0]);
        if(args.length == 4){
            gen.setData(args[3].split(","));
        }
    }

}
