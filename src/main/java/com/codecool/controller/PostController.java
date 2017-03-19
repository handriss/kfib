package com.codecool.controller;


import com.codecool.model.Post;
import com.codecool.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }


    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Iterable<Post> list(){
        return postService.findAll();
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public void create(@RequestBody Post post){
        postService.save(post);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public Post read(@PathVariable(value="id") long id){
        return postService.findById(id);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
    public Post update(@PathVariable(value="id") long id, @RequestBody Post post){
        return postService.update(id,post);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable(value="id") int id){
        postService.deleteById(id);
    }

}
