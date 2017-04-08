package com.codecool.service;


import com.codecool.model.Post;
import com.codecool.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(Post post) {
        post.setPostedOn(new Timestamp(System.currentTimeMillis()));
        postRepository.save(post);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void deleteById(long id){
        this.delete(postRepository.findOne(id));
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findByTitle(String title){
        return postRepository.findByTitle(title);
    }

    public Post findById(Long id){ return postRepository.findById(id);}

    public Post update(long id,Post update) {
        Post post = postRepository.findOne(id);
        if( update.getTitle() != null ) {
            post.setTitle(update.getTitle());
        }
        post.setPostedOn(new Timestamp(System.currentTimeMillis()));
        return postRepository.save(post);
    }
}
