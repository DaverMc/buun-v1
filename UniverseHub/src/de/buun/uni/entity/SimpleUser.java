package de.buun.uni.entity;

import de.buun.uni.BuildersUniverse;

import java.util.UUID;

public class SimpleUser implements User {

    private final UUID uuid;

    public SimpleUser(UUID uuid){
        this.uuid = uuid;
    }

    @Override
    public boolean hasPermission(String permission) {
        //BuildersUniverse.getUser(uuid).hasPermission(permission);
        return true;
    }

    @Override
    public String getLanguage() {
        return "en";
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
    }
}
