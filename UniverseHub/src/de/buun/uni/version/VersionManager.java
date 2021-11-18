package de.buun.uni.version;

import de.buun.uni.collection.Version;

public class VersionManager {

    public final static Version SERVER_VERSION = getServerVersion();

    private static Version getServerVersion(){
        return Version.v_1_8;
    }

}
