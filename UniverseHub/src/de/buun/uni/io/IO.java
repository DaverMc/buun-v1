package de.buun.uni.io;

import de.buun.uni.log.Loggers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO {

    private IO(){}

    public static File createFile(String path){
        File file = new File(path);
        if(file.exists()) return file;
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
            return file;
        }catch (IOException e){
            Loggers.log(e);
            return null;
        }
    }

    public static File createFile(File dir, String name){
        return createFile(dir.getAbsolutePath() + "\\" + name);
    }

    public static BufferedReader createReader(File file){
        try {
            return new BufferedReader(new FileReader(file));
        }catch (IOException e){
            Loggers.log(e);
            return null;
        }
    }

    public static List<String> readAll(BufferedReader reader){
        List<String> list = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }catch (IOException e){
            Loggers.log(e);
        }
        return list;
    }

    public static BufferedWriter createWriter(File file, boolean append){
        try {
            return new BufferedWriter(new FileWriter(file, append));
        }catch (IOException e){
            Loggers.log(e);
            return null;
        }
    }

    public static void writeAll(BufferedWriter writer, List<String> list){
        list.forEach(s -> write(writer, s, true));
    }

    public static void write(BufferedWriter writer, String line, boolean newLine){
        try {
            writer.write(line);
            if(newLine) writer.newLine();
            writer.flush();
        }catch (IOException e){
            Loggers.log(e);
        }
    }

}
