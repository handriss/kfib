package com.codecool.config;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        super.addViewControllers(viewControllerRegistry);
        viewControllerRegistry.addViewController("/login").setViewName("auth/login");
        viewControllerRegistry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
