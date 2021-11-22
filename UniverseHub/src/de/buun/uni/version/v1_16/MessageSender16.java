package de.buun.uni.version.v1_16;

import de.buun.uni.BuildersUniverse;
import de.buun.uni.entity.User;
import de.buun.uni.lang.MessageSender;

public class MessageSender16 implements MessageSender {
    @Override
    public void send(User user, boolean async, String... jsonLines) {
        BuildersUniverse.getSpigotPlayer(user.getUuid()).sendMessage(jsonLines);
    }
}
