package de.buun.uni.sql.database;

import de.buun.uni.io.IO;
import de.buun.uni.log.Loggers;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDatabase extends AbstractDatabase{

    private final String url;

    public SQLiteDatabase(String path){
        this.url = "jdbc:sqlite:" + path;
        IO.createFile(path);
        createConnection();
    }

    @Override
    public void createConnection() {
        try {
            this.connection = DriverManager.getConnection(this.url);
        }catch (SQLException e){
            Loggers.log(e);
        }
    }
}
