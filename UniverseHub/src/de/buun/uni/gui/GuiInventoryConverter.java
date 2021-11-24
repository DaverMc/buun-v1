package de.buun.uni.gui;

import de.buun.uni.entity.User;

public interface GuiInventoryConverter {

    void open(Gui gui, User user);

    void update(Gui gui, User user);

    void close(User user);

}
