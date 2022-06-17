package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProducrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("product")
    private IProducrService producrService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("products", producrService.findAll());
        model.addAttribute("product", new Product());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        product.setId(producrService.findAll().get(producrService.findAll().size() - 1).getId() + 1);
        producrService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", producrService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect) {
        producrService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Updated product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", producrService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        producrService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", producrService.findById(id));
        return "/view";
    }

    @GetMapping(value = "/search")
    public String findAll(Model model, Product product) {
        List<Product> productList = producrService.search(product.getName());
        model.addAttribute("products", productList);
        return "list";
    }
}
