package de.buun.uni.version;

import de.buun.uni.log.Loggers;
import de.buun.uni.util.Reflections;
import org.bukkit.Bukkit;

import java.lang.reflect.InvocationTargetException;

public class VersionManager {

    public final static Version SERVER_VERSION = getServerVersion();

    private static Version getServerVersion(){
        if(SERVER_VERSION != null) return SERVER_VERSION;
        String sVersion = Bukkit.getServer().getClass().getName().split("\\.")[3];
        return Version.getVersion(sVersion);
    }

    public static <T> T createInstance(Class<?> superior, Class<?> cv1_8, Class<?> cv_1_16, Object...args) {
        try {
            Object obj;
            switch (SERVER_VERSION) {
                case v_1_8 : obj =  Reflections.getConstructor(cv1_8, args).newInstance(args);
                break;
                case v_1_16 :  obj = Reflections.getConstructor(cv_1_16,args).newInstance(args);
                    break;
                default : obj = null;
            }
        return (T) superior.cast(obj);
        }catch (InvocationTargetException | InstantiationException | IllegalAccessException e){
            Loggers.log(e);
            return null;
        }
    }

}
