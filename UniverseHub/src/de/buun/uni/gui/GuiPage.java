package de.buun.uni.gui;

import de.buun.uni.item.Item;

public interface GuiPage {

    Item[] getContents();

    void setItem(int id, Item item);

    int getRows();

    int getColumns();
}
