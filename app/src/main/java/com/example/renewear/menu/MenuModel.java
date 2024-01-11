package com.example.renewear.menu;

public class MenuModel {
    private final Integer iconId;
    private final String title;

    public MenuModel(Integer iconId, String title) {
        this.iconId = iconId;
        this.title = title;
    }

    public Integer getIconId() {
        return iconId;
    }

    public String getTitle() {
        return title;
    }
}
