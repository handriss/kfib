package com.codecool.model;

import com.codecool.model.enums.TargetAudienceCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
public class TargetAudienceCategoryTag {

    private TargetAudienceCategory targetAudienceCategory;

    private TargetAudienceCategoryTag() {}

    @Override
    public String toString() {
        return targetAudienceCategory.toString();
    }
}
