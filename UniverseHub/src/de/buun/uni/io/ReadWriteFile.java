package de.buun.uni.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadWriteFile {

    private final File file;
    private Map<String, String> values;

    public ReadWriteFile(String path){
        this.file = IO.createFile(path);
        reload();
    }

    private Map<String, String> read(){
        Map<String , String> map = new LinkedHashMap<>();
        BufferedReader reader = IO.createReader(this.file);
        if(reader == null) return map;
        IO.readAll(reader).forEach(s -> {
            String[] splitt = s.split(": ");
            map.put(splitt[0], splitt[1]);
        });
        return map;
    }

    public String get(String path){
        return this.values.get(path);
    }

    public void set(String path, String value){
        this.values.put(path, value);
    }

    public void set(String path, String value, boolean update){
        set(path, value);
        if(update) update();
    }

    public void remove(String path){
        this.values.remove(path);
    }

    public void remove(String path, boolean update){
        remove(path);
        if(update) update();
    }

    public void update(){
        BufferedWriter writer = IO.createWriter(this.file, false);
        List<String> lines = new ArrayList<>();
        this.values.forEach((k, v) -> lines.add(k + ": " + v));
        IO.writeAll(writer, lines);
    }

    public void reload(){
        this.values = read();
    }

}
