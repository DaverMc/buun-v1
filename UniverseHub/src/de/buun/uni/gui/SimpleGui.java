package de.buun.uni.gui;

import de.buun.uni.entity.User;
import de.buun.uni.version.VersionManager;
import de.buun.uni.version.v1_16.GuiInventoryConverter16;
import de.buun.uni.version.v1_8.GuiInventoryConverter8;

import java.util.ArrayList;
import java.util.List;

public class SimpleGui implements Gui {

    private final String name;
    private final GuiPage firstPage;
    private GuiPage activePage;
    private final List<GuiPage> pages;
    private final GuiInventoryConverter converter;
    private final int rows;

    public SimpleGui(String name, GuiPage firstPage){
        this.name = name;
        this.converter = VersionManager.createInstance(GuiInventoryConverter.class, GuiInventoryConverter8.class, GuiInventoryConverter16.class);
        this.firstPage = firstPage;
        this.activePage = firstPage;
        this.pages = new ArrayList<>();
        this.rows = firstPage.getRows();
    }

    @Override
    public void setPage(int id) {
        if(id >= pages.size()) return;
        GuiPage page = pages.get(id);
        if(page == null) return;
        activePage = page;
    }

    @Override
    public void open(User user) {
        converter.open(this, user);
    }

    @Override
    public void update(User user) {
        if(activePage.getRows() != rows){
            close(user);
            open(user);
            return;
        }
        converter.update(this, user);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public GuiPage getActivePage() {
        return this.activePage;
    }

    @Override
    public void close(User user) {
        converter.close(user);
    }

    @Override
    public int getRows() {
        return this.rows;
    }
}
