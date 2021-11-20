package de.buun.buga.world;

import de.buun.uni.sql.Column;
import de.buun.uni.sql.Database;
import de.buun.uni.sql.SQLDataType;
import de.buun.uni.sql.SimpleTable;

public class CategoryTable extends SimpleTable<String> {

    public CategoryTable(Database db) {
        super(db,
                "categories",
                new Column("name", SQLDataType.TEXT),
                new Column("symbol", SQLDataType.TEXT),
                new Column("worldCount", SQLDataType.INTEGER));
    }
}
