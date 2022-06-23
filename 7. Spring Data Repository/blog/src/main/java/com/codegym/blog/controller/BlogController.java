package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.impl.BlogService;
import com.codegym.blog.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
//    @Qualifier("blog")
    private BlogService blogService;
    @Autowired
//    @Qualifier("category")
    private CategoryService categoryService;

    @GetMapping
    public String getAllStudent(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("date").ascending().and(Sort.by("title"));
        Page<Blog> list = blogService.getAll(PageRequest.of(page, 2, sort));
        model.addAttribute("blogs", list);
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", new Category());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory", categoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        blogService.delete(id);
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("listCategory", categoryService.findAll());
        model.addAttribute("blog", blogService.findByIdBlog(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirect) {

        blogService.update(blog);
        redirect.addFlashAttribute("success", "Updated blog successfully!");
        return "redirect:/";
    }

    @GetMapping(value = "/search")
    public String findAll(Model model, Blog blog) {
        List<Blog> blogList = blogService.search(blog.getTitle());
        model.addAttribute("blogs", blogList);
        return "search";
    }
}
