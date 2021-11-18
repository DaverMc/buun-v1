package test;

import de.buun.uni.io.LanguageFile;
import de.buun.uni.log.Level;
import de.buun.uni.log.LogFile;
import de.buun.uni.log.Loggers;

import java.io.File;

public class Main {

    public static void main(String[] args){
        File dir = new File("C:\\Users\\denni\\Desktop\\BuildersUniverse");
        Loggers.registerLog(new LogFile(dir, "log"));
        Loggers.log(Level.ERROR, "Test Error");

        LanguageFile file = new LanguageFile(dir, "de");
        file.set("test", "Das ist ein Testtext", true);
    }

}
