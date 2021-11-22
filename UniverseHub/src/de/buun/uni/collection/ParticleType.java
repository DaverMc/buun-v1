package de.buun.uni.collection;

import de.buun.uni.version.Version;
import de.buun.uni.version.VersionManager;

public enum ParticleType {

    AIR("air");

    private final String v8;
    private final String release;
    private final Version releaseVersion;

    ParticleType(String v8){
        this.v8 = v8;
        this.release = v8;
        this.releaseVersion = Version.v_1_8;
    }

    ParticleType(String v8, String v, Version update){
        this.v8 = v8;
        this.release = v;
        this.releaseVersion = update;
    }

    public String getName(){
        if(Version.isNewer(VersionManager.SERVER_VERSION, releaseVersion)){
            return release;
        }
        return v8;
    }

}
