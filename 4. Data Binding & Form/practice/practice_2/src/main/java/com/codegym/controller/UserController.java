package com.codegym.controller;

import com.codegym.dao.UserDao;
import com.codegym.model.Login;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("login", new Login());
        return "home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, Model model) {
        User user = UserDao.checkLogin(login);
        if (user == null) {
            return "error";
        } else {
            model.addAttribute("user", user);
            return "user";
        }
    }
}
