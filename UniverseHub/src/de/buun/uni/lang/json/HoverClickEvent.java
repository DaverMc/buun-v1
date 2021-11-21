package de.buun.uni.lang.json;

public class HoverClickEvent extends JSONEvent{

    private final JSONEventType clickType, hoverType;

    public HoverClickEvent(JSONEventType clickType, JSONEventType hoverType){
        this.clickType = clickType;
        this.hoverType = hoverType;
        this.values = new String[3];
    }

    public HoverClickEvent setText(String text){
        this.values[0] = text;
        return this;
    }

    public HoverClickEvent setClickValue(String value){
        this.values[1] = value;
        return this;
    }

    public HoverClickEvent setHoverValue(String value){
        this.values[2] = value;
        return this;
    }

    @Override
    public String toJson() {
        return "Hier muss noch die Übersetzung in JSON rein"; //TODO
    }

}
