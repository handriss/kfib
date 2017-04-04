package com.codecool.service;

import com.codecool.model.PostCategory;
import com.codecool.repository.PostCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCategoryService {

    PostCategoryRepository postCategoryRepository;

    @Autowired
    public PostCategoryService(PostCategoryRepository postCategoryRepository) {
        this.postCategoryRepository = postCategoryRepository;
    }

    public void save(PostCategory postCategory){
        postCategoryRepository.save(postCategory);
    }

    public List<PostCategory> findAll(){
        return postCategoryRepository.findAll();
    }

    public PostCategory findByname(String name){
        return postCategoryRepository.findByName(name);
    }
}
