package de.buun.uni.log;

public enum Level {

    INFO("INFO"),
    ERROR("ERROR");

    private final String name;

    Level(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
