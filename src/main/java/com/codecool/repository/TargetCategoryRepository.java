package com.codecool.repository;


import com.codecool.model.Post;
import com.codecool.model.TargetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetCategoryRepository extends JpaRepository<TargetCategory, Long> {

    Post findByName(String name);

    Post findById(Long id);

}
