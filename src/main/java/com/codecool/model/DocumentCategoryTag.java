package com.codecool.model;

import com.codecool.model.enums.DocumentCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@ToString
@AllArgsConstructor
public class DocumentCategoryTag {

    private DocumentCategory documentCategory;

    private DocumentCategoryTag() {}
}
