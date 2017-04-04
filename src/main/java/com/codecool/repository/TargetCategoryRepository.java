package com.codecool.repository;


import com.codecool.model.TargetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetCategoryRepository extends JpaRepository<TargetCategory, Long> {

    TargetCategory findByName(String name);

    TargetCategory findById(Long id);

}
