package com.codecool.repository;


import com.codecool.domain.Author;
import com.codecool.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Post findByEmail(String email);

}
