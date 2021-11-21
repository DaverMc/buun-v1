package de.buun.uni.lang;

import de.buun.uni.lang.json.JSONEvent;

public class MessageNode implements Message {

    private final String value;
    private Message next;

    public MessageNode(String value){
        this.value = value;
    }

    @Override
    public Message next() {
        return this.next;
    }

    @Override
    public String toJson() {
        return JSONEvent.textToJson(this.value);
    }

    @Override
    public void setNext(Message message) {
        this.next = message;
    }

}
