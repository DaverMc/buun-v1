package de.buun.uni.lang.json;

public enum JSONEventType {

    CLICK_A(true, false, "click"),

    HOVER_A(false, true, "hover");

    private final boolean hover, click;
    private final String json;

    JSONEventType(boolean hover, boolean click, String jsonName){
        this.hover = hover;
        this.click = click;
        this.json = jsonName;
    }

    public boolean isClickable(){
        return this.click;
    }

    public boolean isHoverable(){
        return this.hover;
    }

    public String getName(){
        return this.json;
    }
}
