package de.buun.buga.world;

import de.buun.uni.sql.Column;
import de.buun.uni.sql.Database;
import de.buun.uni.sql.SQLDataType;
import de.buun.uni.sql.SimpleTable;

public class WorldTable extends SimpleTable<String> {

    public WorldTable(Database database) {
        super(database,
                "worlds",
                new Column("worldId", SQLDataType.TEXT),
                new Column("name", SQLDataType.TEXT),
                new Column("loaded", SQLDataType.INTEGER),
                new Column("stopLag", SQLDataType.INTEGER),
                new Column("genId", SQLDataType.INTEGER),
                new Column("genData", SQLDataType.TEXT),
                new Column("activeVersion", SQLDataType.INTEGER),
                new Column("symbol", SQLDataType.TEXT));
    }
}
