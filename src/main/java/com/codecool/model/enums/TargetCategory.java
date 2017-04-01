package com.codecool.model.enums;


public enum TargetCategory {
    UJSAGIROKNAK("Újságíróknak"),
    ELEMZOKNEK("Elemzőknek"),
    CIVILEKNEK("Civileknek"),
    ZSUGABUBUSNAK("Zsugabubusnak"),
    EGYEB("Más célközönségnek");

    private final String displayName;

    TargetCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
