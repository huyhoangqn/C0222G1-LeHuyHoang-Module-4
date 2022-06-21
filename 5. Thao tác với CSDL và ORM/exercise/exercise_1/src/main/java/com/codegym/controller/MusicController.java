package com.codegym.controller;


import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {
    @Autowired
    @Qualifier("music")
    private IMusicService musicService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list", musicService.findAll());
        model.addAttribute("music", new Music());
        return "home";
    }
}
