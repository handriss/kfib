package com.codecool.model.enums;


public enum DocumentCategory {

    transparency("Átláthatóság"),
    baselineProjection("Technikai kivetítés"),
    budgetAnalysis("Költségvetési elemzés"),
    methodology("Módszertan"),
    obi("OBI"),
    impactAssessment("Hatásvizsgálat"),
    other("Egyéb elemzések");

    private String descriptiveName;

    DocumentCategory(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    public String getName() {
        return descriptiveName;
    }
}
