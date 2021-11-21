package de.buun.uni.lang;

import de.buun.uni.entity.User;
import de.buun.uni.lang.json.JSONEvent;
import de.buun.uni.version.VersionManager;
import de.buun.uni.version.v1_16.MessageSender16;
import de.buun.uni.version.v1_8.MessageSender8;

import java.util.List;

//Um eine neue Nachricht anzufangen

public class MessageBuilder {

    private final static MessageSender messageSender = getMessageSender();

    private Message first;
    private Message last;

    public MessageBuilder(){}

    public MessageBuilder(JSONEvent jsonEvent){
        this.first = jsonEvent;
        this.last = first;
    }

    public MessageBuilder(String text){
        this.first = new MessageNode(text);
        this.last = first;
    }

    public MessageBuilder add(String value){
        if(first == null) {
            first = new MessageNode(value);
            last = first;
            return this;
        }
        Message m = new MessageNode(value);
        last.setNext(m);
        last = m;
        return this;
    }

    public MessageBuilder newLine(){
        if(first == null) return this;
        Message m = new MessageNode(":/n:");
        last.setNext(m);
        last = m;
        return this;
    }

    public void send(User user){
        messageSender.send(user, false, createJson());
    }

    public void broadcast(List<User> users){
        String[] json = createJson();
        users.forEach(user ->
            messageSender.send(user, false, json)
        );
    }
    //Hängt alle Json Teile hintereinander und verbindet sie sodass ein zusammenhängender JSon Text entsteht bei :/n: eine neue Zeile beginnen
    private String[] createJson(){
        return new String[0];
    }

    private static MessageSender getMessageSender(){
        return VersionManager.createInstance(MessageSender.class, MessageSender8.class, MessageSender16.class);
    }

}
