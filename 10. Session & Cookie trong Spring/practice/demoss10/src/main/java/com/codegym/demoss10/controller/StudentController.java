package com.codegym.demoss10.controller;

import com.codegym.demoss10.model.Student;
import com.codegym.demoss10.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping(value = "/list")
    public String list(Model model, @CookieValue(value = "cookieValue", defaultValue = "0") Integer countStudent) {
        model.addAttribute("studentList", studentService.list());
        model.addAttribute("cookieValue", countStudent);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showFromCreate(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping(value = "/create")
    public String create(Student student, @CookieValue(value = "cookieValue", defaultValue = "0") Integer countStudent, HttpServletResponse response) {
        studentService.save(student);
        Cookie cookie = new Cookie("cookieValue", countStudent + 1 + "");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        return "redirect:/list";
    }
}
