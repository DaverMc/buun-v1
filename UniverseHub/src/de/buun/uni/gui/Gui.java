package de.buun.uni.gui;

import de.buun.uni.entity.User;

public interface Gui {

    void setPage(int id);

    void open(User user);

    void update(User user);

    String getName();

    GuiPage getActivePage();

    void close(User user);

    int getRows();
}
