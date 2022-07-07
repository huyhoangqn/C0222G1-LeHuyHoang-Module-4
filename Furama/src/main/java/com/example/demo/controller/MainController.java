package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class MainController {

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/403")
    public String accessDenied() {
        return "403Page";
    }
}