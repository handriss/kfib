package com.codecool.controller;


import com.codecool.service.PostService;
import com.codecool.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class AdminController {

    private PostService postService;
    private UserService userService;

    @Autowired
    public AdminController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping("/admin/posts")
    public String list(Model model){
        model.addAttribute("posts", postService.findAll());
        log.info(postService.findAll().toString());
        return "admin/list";
    }

    @RequestMapping("/authors")
    public String list2(Model model){
        model.addAttribute("posts", postService.findAll());
        return "admin/list";
    }

}
