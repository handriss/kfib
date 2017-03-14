package com.codecool.controller;


import com.codecool.domain.Post;
import com.codecool.domain.User;
import com.codecool.service.PostService;
import com.codecool.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Controller
public class AdminController {

    private PostService postService;
    private UserService userService;

    @Autowired
    public AdminController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/admin/posts")
    public String list(Model model){
        model.addAttribute("posts", postService.findAll());
        log.info(postService.findAll().toString());
        return "admin/list";
    }

    @GetMapping("/admin/create-post")
    public String createPost(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "admin/create-post";
    }

    @PostMapping("/admin/create")
    public String savePost(Post post){
//        Set<User> emptySet = new HashSet();
//        post.setUsers(emptySet);
        postService.save(post);
        return "admin/list";
    }
}