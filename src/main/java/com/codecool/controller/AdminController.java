package com.codecool.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @RequestMapping("/admin/posts")
    public String list(){
        return "Listing posts...";
    }
}
