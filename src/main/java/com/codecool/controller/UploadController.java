package com.codecool.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin")
public class UploadController {

    @GetMapping("/upload-file")
    public String homeUpload(){

        log.info("upload called with get method...");

        return "admin/upload";
    }

    @PostMapping("/upload-file")
    public String saveFile(){
        log.info("upload called with post method...");

        return "redirect:/admin/posts";
    }

}
