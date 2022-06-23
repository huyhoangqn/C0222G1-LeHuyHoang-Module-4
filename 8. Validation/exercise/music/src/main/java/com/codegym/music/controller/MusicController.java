package com.codegym.music.controller;

import com.codegym.music.model.Music;
import com.codegym.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("listMusic", musicService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@Valid Music music, BindingResult bindingResult, RedirectAttributes redirect) {
        new Music().validate(music, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            musicService.create(music);
            redirect.addFlashAttribute("success", "register complete ");
            return "redirect:/list";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Music music, RedirectAttributes redirect) {
        musicService.save(music);
        redirect.addFlashAttribute("success", "update complete ");
        return "redirect:/list";
    }
}
