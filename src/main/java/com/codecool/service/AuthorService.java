package com.codecool.service;


import com.codecool.domain.Author;
import com.codecool.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void delete(Author author) {
        authorRepository.delete(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findByTitle(String title){
        return authorRepository.findByEmail(title);
    }
}
