package de.buun.uni.lang;

import de.buun.uni.entity.User;

public interface MessageSender {

    void send(User user, boolean async, String...jsonLines);

}
