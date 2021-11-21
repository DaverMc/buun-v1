package de.buun.uni.lang.json;

public class TextHoverEvent extends JSONEvent{

    private final JSONEventType type;

    public TextHoverEvent(JSONEventType type){
        this.type = type;
        this.values = new String[2];
    }

    public TextHoverEvent setValue(String value){
        this.values[0] = value;
        return this;
    }

    public TextHoverEvent setText(String text){
        this.values[1] = text;
        return this;
    }



    @Override
    public String toJson() {
        return JSONEvent.eventToJson("hoverevent", this.type.getName(), this.values[0], this.values[1]);
    }
}
