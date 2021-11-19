package de.buun.uni.sql;

public class Column {

    protected final String name;
    protected final SQLDataType type;

    public Column(String name, SQLDataType type){
        this.name = name;
        this.type = type;
    }

}
