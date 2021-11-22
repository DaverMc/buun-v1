package de.buun.uni.version;

public enum Version {

    v_1_8(8,"v1_8_R3"),
    v_1_9(9),
    v_1_10(10),
    v_1_11(11),
    v_1_12(12),
    v_1_13(13),
    v_1_14(14),
    v_1_15(15),
    v_1_16(16, "v1_16_R3"),
    v_1_17(17),
    v_1_18(18);

    private final int version;
    private final String bukkitName;

    Version(int version){
        this.version = version;
        bukkitName = null;
    }

    Version(int version, String bukkitName){
        this.version = version;
        this.bukkitName = bukkitName;
    }

    public static boolean isNewer(Version newer, Version older){
        return newer.version > older.version;
    }

    public static Version getVersion(String bukkitVersion){
        for (Version v : Version.values()){
            if(bukkitVersion.equals(v.bukkitName)) return v;
        }
        return null;
    }

}
