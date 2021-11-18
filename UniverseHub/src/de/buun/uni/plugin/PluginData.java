package de.buun.uni.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PluginData {

    String name();
    String version();
    String[] authors();
    //PluginLoadOrder load(); Später hinzufügen
    //String[] description(); Find ich unnötig

}
