package com.codecool.service;

import com.codecool.model.enums.DocumentCategory;
import com.codecool.model.enums.TargetAudienceCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TagService {

    public DocumentCategory[] getDocumentCategories(){
        return DocumentCategory.values();
    }

    public TargetAudienceCategory[] getTargetAudienceCategories(){
        return TargetAudienceCategory.values();
    }

}
