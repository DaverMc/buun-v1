package de.buun.uni.lang;

public interface Message {

    Message next();

    String toJson();

    void setNext(Message message);
}
