package de.buun.uni.lang.json;

public class TextClickEvent extends JSONEvent{

    private final JSONEventType type;

    public TextClickEvent(JSONEventType type){
        this.type = type;
        this.values = new String[2];
    }

    public TextClickEvent setValue(String value){
        this.values[0] = value;
        return this;
    }

    public TextClickEvent setText(String text){
        this.values[1] = text;
        return this;
    }

    @Override
    public String toJson() {
        return JSONEvent.eventToJson("clickevent", type.getName(), this.values[0], this.values[1]);
    }
}
