package com.codecool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class BootBaseApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello, Heroku!";
    }

    public static void main(String[] args) {
        SpringApplication.run(BootBaseApplication.class, args);
    }
}
