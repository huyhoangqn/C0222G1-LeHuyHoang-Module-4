package com.codegym.register_form.controller;

import com.codegym.register_form.model.User;
import com.codegym.register_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@Valid User user, BindingResult bindingResult, Model model) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            userService.create(user);
            model.addAttribute("msg", "register complete ");
            return "message";
        }
    }
}
