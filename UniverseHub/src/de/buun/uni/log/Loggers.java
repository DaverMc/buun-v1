package de.buun.uni.log;

import java.util.ArrayList;
import java.util.List;

public class Loggers {

    private final static List<LogFile> loggers = new ArrayList<>();

    private Loggers(){}

    public static void log(Level level, String message){
        loggers.stream()
                .filter(logFile -> logFile.isLevel(level))
                .forEach(logFile -> logFile.log(level, message));
        System.out.println("[" + level.getName() + "]: " + message);
    }

    public static void log(Exception e){
        log(Level.ERROR, e.getMessage());
    }

    public static void registerLog(LogFile logger){
        if(loggers.contains(logger)) return;
        loggers.add(logger);
    }
}
