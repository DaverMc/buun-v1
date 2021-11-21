package de.buun.uni.sql;

import de.buun.uni.sql.database.DbUpdateService;

import java.sql.Connection;
import java.util.Map;

public interface Database {

    Map<String, Table<?>> getTables();

    Connection connect();

    void createConnection();

    void closeConnection();

    void postUpdate();

    void addTable(Table<?> table);

    Database setUpdateService(DbUpdateService service);

    DbUpdateService getService();

    boolean isConnected();

    <T> T getTable(String id);

}
