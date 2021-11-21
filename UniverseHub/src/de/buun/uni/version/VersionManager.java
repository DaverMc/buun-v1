package de.buun.uni.version;

import de.buun.uni.collection.Version;

public class VersionManager {

    public final static Version SERVER_VERSION = getServerVersion();

    private static Version getServerVersion(){
        return Version.v_1_8;
    }

    public static <T> T createInstance(Class<?> superior, Class<?> cv1_8, Class<?> cv_1_16){
        return null;
    }

}
