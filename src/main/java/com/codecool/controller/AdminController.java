package com.codecool.controller;


import com.codecool.exception.PostNotFoundException;
import com.codecool.model.File;
import com.codecool.model.Post;
import com.codecool.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        Post post = new Post();
        model.addAttribute("post", post);
        return "admin/create-post";
    }

    @PostMapping("/create-post")
    public String savePost(Post post){

        postService.save(post);
        return "redirect:/admin/posts";
    }

    @GetMapping("/browse-files")
    public String browseFiles(Model model){

        List<File> files = fileService.findAll();
        model.addAttribute("files", files);

        return "admin/browse-files";
    }

    @GetMapping("/upload-files")
    public String uploadFiles(Model model){

        return "admin/upload-files";
    }

    @RequestMapping( value = "/posts/{id}", method = RequestMethod.GET )
    public String getPost(@PathVariable(value="id") long id, Model model){

        Post post = postService.findById(id);

        if(post == null){
            throw new PostNotFoundException("Az általad megadott azonosítóhoz (" + id + ") nem tartozik tartalom.");
        }

        model.addAttribute("post", post);

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