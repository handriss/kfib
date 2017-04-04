package com.codecool.service;

import com.codecool.model.TargetCategory;
import com.codecool.repository.PostCategoryRepository;
import com.codecool.repository.TargetCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetCategoryService {

    TargetCategoryRepository targetCategoryRepository;

    @Autowired
    public TargetCategoryService(PostCategoryRepository postCategoryRepository) {
        this.targetCategoryRepository = targetCategoryRepository;
    }

    public void save(TargetCategory targetCategory){
        targetCategoryRepository.save(targetCategory);
    }

    public List<TargetCategory> findAll(){
        return targetCategoryRepository.findAll();
    }

    public TargetCategory findByname(String name){
        return targetCategoryRepository.findByName(name);
    }
}
