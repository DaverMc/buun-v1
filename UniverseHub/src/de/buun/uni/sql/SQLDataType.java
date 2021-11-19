package de.buun.uni.sql;

import java.sql.Date;

public enum SQLDataType {

    INTEGER("INTEGER", Integer.class),
    TEXT("TEXT", String.class),
    DATE("DATE", Date.class);

    private final Class<?> type;
    private final String sql;

    SQLDataType(String sqlName, Class<?> type){
        this.type = type;
        this.sql = sqlName;
    }

    public Class<?> getJavaClass(){
        return this.type;
    }

    public String getSql(){
        return this.sql;
    }
}
