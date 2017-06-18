package com.codecool.model.enums;

public enum TargetAudienceCategory {

    journalist("Újságíró"),
    decisionMaker("Döntéshozó"),
    ngo("Civil szervezet"),
    analyst("Elemező"),
    citizen("Állampolgár");

    private String descriptiveName;

    TargetAudienceCategory(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    public String getName() {
        return descriptiveName;
    }
}
