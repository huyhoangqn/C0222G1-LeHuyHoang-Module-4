package com.codegym.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("home")
@RequestMapping
public class HomeController {
    @GetMapping
    public String home() {
        return "home";
    }
}
