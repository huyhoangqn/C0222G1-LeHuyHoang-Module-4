package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping(value = "/word")
    public String inputWord() {
        return "dictionary";
    }

    @PostMapping(value = "/dictionary")
    public String dictionary(@RequestParam String word, Model model) {
        model.addAttribute("result", dictionaryService.dictionary(word));
        return "result";
    }


}
