package com.codecool.controller;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;


public class LoginRedirectController extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    public LoginRedirectController() {
        super();
        setUseReferer(true);
    }
}
