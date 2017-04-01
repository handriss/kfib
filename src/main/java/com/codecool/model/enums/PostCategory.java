package com.codecool.model.enums;


public enum PostCategory {
    TECHNIKAI_KIVETÍTÉS("Technikai kivetítés"),
    KÖLTSÉGVETÉSI_ELEMZÉS("Költségvetési elemzés"),
    EGYÉB("Egyéb");

    private final String displayName;

    PostCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
