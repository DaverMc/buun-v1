package de.buun.uni.lang.json;

import de.buun.uni.lang.Message;

public abstract class JSONEvent implements Message {

    private Message next;
    protected String[] values;

    @Override
    public Message next() {
        return this.next;
    }

    @Override
    public String consoleValue() {
        return "jsonEvent";
    }

    @Override
    public void setNext(Message message) {
        this.next = message;
    }

    public void setValues(String...values){
        this.values = values;
    }


    public static String textToJson(String text){
        return "";
    }

    public static String eventToJson(String eventName, String eventType, String value, String text){
        return "";
    }
}
