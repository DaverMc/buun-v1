package de.buun.uni.sql.database;

public interface DbUpdateService {

    void update();

    void start();

    void stop();

    boolean isRunning();

}
