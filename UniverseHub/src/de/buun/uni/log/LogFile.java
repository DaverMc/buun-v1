package de.buun.uni.log;

import de.buun.uni.io.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LogFile {

    private final File file;
    private Level[] levels; //if null log everything

    public LogFile(File dir, String name){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd"));
        this.file = IO.createFile(dir, time + "-" + name + ".log");
    }

    public void log(Level level, String message){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        String text = "[" + level.getName() + "][" + time + "]: " + message;
        BufferedWriter writer = IO.createWriter(this.file, true);
        if(writer == null) return;
        IO.write(writer, text, true);
    }

    public void setLevels(Level...levels){
        this.levels = levels;
    }

    public boolean isLevel(Level level) {
        if(levels == null) return true;
        return Arrays.stream(this.levels).toList().contains(level);
    }

}
