package de.buun.uni.entity;

public class SimpleConsole implements Console{
    @Override
    public boolean hasPermission(String permission) {
        return true;
    }

    @Override
    public String getLanguage() {
        return "en";
    }
}
