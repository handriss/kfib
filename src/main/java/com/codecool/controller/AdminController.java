package com.codecool.controller;


import com.codecool.exception.PostNotFoundException;
import com.codecool.model.File;
import com.codecool.model.Post;
import com.codecool.service.FileService;
import com.codecool.service.PostService;
import com.codecool.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    private PostService postService;
    private UserService userService;
    private FileService fileService;

    @Autowired
    public AdminController(PostService postService, UserService userService, FileService fileService) {
        this.postService = postService;
        this.userService = userService;
        this.fileService = fileService;
    }

    @GetMapping("/posts")
    public String list(Model model){
        model.addAttribute("posts", postService.findAll());
        return "admin/list";
    }

    @GetMapping("/create-post")
    public String createPost(Model model){

        List<File> files = fileService.findAll();
        model.addAttribute("files", files);

//        List<String> tags = new ArrayList<>(Arrays.asList("Újságíróknak", "Elemzőknek", "Civileknek", "Egyéb"));
//        model.addAttribute("tags", tags);
//
//        List<String> types = new ArrayList<>(Arrays.asList("Technikai kivetítés", "Költségvetési elemzés", "Egyéb"));
//        model.addAttribute("types", types);

        Post post = new Post();
        model.addAttribute("post", post);
        return "admin/create-post";
    }

    @PostMapping("/create-post")
    public String savePost(Post post){


        postService.save(post);
        return "redirect:/admin/posts";
    }

    @RequestMapping( value = "/posts/{id}", method = RequestMethod.GET )
    public String getPost(@PathVariable(value="id") long id, Model model){

        Post post = postService.findById(id);

        if(post == null){
            throw new PostNotFoundException("Az általad megadott azonosítóhoz (" + id + ") nem tartozik tartalom.");
        }

        model.addAttribute("post", post);

        List<String> tags = new ArrayList<>(Arrays.asList("Újságíróknak", "Elemzőknek", "Civileknek", "Egyéb"));
        model.addAttribute("tags", tags);

        List<String> types = new ArrayList<>(Arrays.asList("Technikai kivetítés", "Költségvetési elemzés", "Egyéb"));
        model.addAttribute("types", types);

        return "admin/create-post";
    }

    @GetMapping("/delete-post/{id}")
    public String deletePost(@PathVariable(value="id") long id){
        postService.deleteById(id);
        return "redirect:/admin/posts";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String handleWrongFormatId(Model model){
        model.addAttribute("message", "Az általad megadott azonosító nem szám formátumú. Kérlek, egész számot adj meg.");

        return "error/post-not-found";
    }

    @ExceptionHandler(PostNotFoundException.class)
    public String handlePostWithIdDoesNotExist(Model model, PostNotFoundException exception){
        model.addAttribute("message", exception.getMessage());

        return "error/post-not-found";
    }

}