package com.codecool.repository;


import com.codecool.model.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {

    PostCategory findByName(String name);

    PostCategory findById(Long id);

}
