package com.codecool.repository;


import com.codecool.model.Post;
import com.codecool.model.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {

    Post findByName(String name);

    Post findById(Long id);

}
