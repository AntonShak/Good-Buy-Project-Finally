package com.shakov.goodbuyproject.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping()
    public String loginPage() {
        return "user/login";
    }

    @PostMapping
    public String fromLoginPageToHomePage() {
        return "home";
    }

}
