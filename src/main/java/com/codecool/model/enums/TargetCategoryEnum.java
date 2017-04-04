package com.codecool.model.enums;

import lombok.Getter;

@Getter
public enum TargetCategoryEnum {
    ANALYSTS("Elemzőknek"),
    JOURNALIST("Újságíróknak"),
    CIVILIAN("Civileknek"),
    OTHER("Más célközönségnek");

    private final String name;

    TargetCategoryEnum(String name) {
        this.name = name;
    }
}
