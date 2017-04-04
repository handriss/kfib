package com.codecool.model.enums;

import lombok.Getter;

@Getter
public enum PostCategoryEnum {

    BASELNIE_PROJECTION("Technikai kivetítés"),
    BUDGET_ANALYSIS("Költségvetési elemzés"),
    OTHER("Egyéb");

    private final String name;

    PostCategoryEnum(String name) {
        this.name = name;
    }
}
