package com.codecool.controller;


import com.codecool.service.PostService;
import com.codecool.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private PostService postService;
    private TagService tagService;

    @Autowired
    public HomeController(PostService postService, TagService tagService) {
        this.postService = postService;
        this.tagService = tagService;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("documentCategoryTags", tagService.getDocumentCategories());
        model.addAttribute("targetAudienceTags", tagService.getTargetAudienceCategories());
        return "index";
    }

    @RequestMapping("/projects")
    public String getProjects(Model model){
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("documentCategoryTags", tagService.getDocumentCategories());
        model.addAttribute("targetAudienceTags", tagService.getTargetAudienceCategories());
        return "index";
    }

    @RequestMapping("/data")
    public String getData(Model model){
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("documentCategoryTags", tagService.getDocumentCategories());
        model.addAttribute("targetAudienceTags", tagService.getTargetAudienceCategories());
        return "index";
    }

    @RequestMapping("/press")
    public String getPress(Model model){
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("documentCategoryTags", tagService.getDocumentCategories());
        model.addAttribute("targetAudienceTags", tagService.getTargetAudienceCategories());
        return "index";
    }

    @RequestMapping("/aboutus")
    public String getAboutUs(Model model){
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("documentCategoryTags", tagService.getDocumentCategories());
        model.addAttribute("targetAudienceTags", tagService.getTargetAudienceCategories());
        return "index";
    }

    @RequestMapping("/contact")
    public String getContact(Model model){
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("documentCategoryTags", tagService.getDocumentCategories());
        model.addAttribute("targetAudienceTags", tagService.getTargetAudienceCategories());
        return "index";
    }

}
