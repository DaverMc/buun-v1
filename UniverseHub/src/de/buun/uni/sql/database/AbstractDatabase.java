package de.buun.uni.sql.database;

import de.buun.uni.log.Loggers;
import de.buun.uni.sql.Database;
import de.buun.uni.sql.Table;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDatabase implements Database {

    private final Map<String, Table<?>> tableMap;
    private DbUpdateService service;
    protected Connection connection;

    public AbstractDatabase(){
        this.tableMap = new HashMap<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            Loggers.log(e);
        }
    }

    @Override
    public Database setUpdateService(DbUpdateService service) {
        if(this.service.isRunning()) this.service.stop();
        this.service = service;
        return this;
    }

    @Override
    public Map<String, Table<?>> getTables() {
        return this.tableMap;
    }

    @Override
    public void postUpdate() {
        tableMap.values().forEach(Table::postUpdate);
    }

    @Override
    public void addTable(Table<?> table) {
        this.tableMap.put(table.getName().toLowerCase(), table);
    }

    @Override
    public DbUpdateService getService() {
        return this.service;
    }

    @Override
    public void closeConnection() {
        try {
            if(!this.connection.isClosed()) return;
            this.connection.close();
        }catch (SQLException e){
            Loggers.log(e);
        }
    }

    @Override
    public Connection connect() {
        return this.connection;
    }

    @Override
    public boolean isConnected() {
        if(this.connection == null) return false;
        try {
            return !this.connection.isClosed();
        }catch (SQLException e){
            Loggers.log(e);
            return false;
        }
    }

    public <T> T getTable(String id){
        return (T) this.tableMap.get(id.toLowerCase());
    }
}
