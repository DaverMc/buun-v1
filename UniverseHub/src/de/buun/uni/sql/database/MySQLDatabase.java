package de.buun.uni.sql.database;

import de.buun.uni.log.Loggers;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase extends AbstractDatabase{

    private final String url;
    private final String user;
    private final String password;

    public MySQLDatabase(String user, String password, String link){
        this.url = "jdbc:mysql:" + link;
        this.user = user;
        this.password = password;
    }


    @Override
    public void createConnection() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        }catch (SQLException e){
            Loggers.log(e);
        }
    }
}
