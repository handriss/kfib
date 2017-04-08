package com.codecool.repository;

import com.codecool.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long>{

    File findById(Long id);

    File findByName(String name);

}
