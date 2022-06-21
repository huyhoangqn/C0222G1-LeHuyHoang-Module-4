package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogServide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogColtroller {
    @Autowired
    private IBlogServide iBlogServide;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("blogs", iBlogServide.findAllBlog());
        model.addAttribute("blog", new Blog());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        iBlogServide.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogServide.findByIdBlog(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirect) {
        iBlogServide.update(blog);
        redirect.addFlashAttribute("success", "Updated blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        Blog blog = iBlogServide.findByIdBlog(id);
        iBlogServide.delete(blog);
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        Blog blog = iBlogServide.findByIdBlog(id);
        model.addAttribute("blog", blog);
        return "/view";
    }

    @GetMapping(value = "/search")
    public String findAll(Model model, Blog blog) {
        List<Blog> blogList = iBlogServide.search(blog.getNameBlog());
        model.addAttribute("blogs", blogList);
        return "list";
    }
}
