package com.codegym.product2.controller;

import com.codegym.product2.dto.ProductDTO;
import com.codegym.product2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String getAllProduct(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<ProductDTO> list = productService.findAllProduct(PageRequest.of(page, 1));
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("products", list);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("productdto", new ProductDTO());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid ProductDTO productDTO, BindingResult bindingResult) {
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            productService.save(productDTO);
            return "redirect:/";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findByIdProduct(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(ProductDTO productDTO, RedirectAttributes redirect) {
        productService.update(productDTO);
        redirect.addFlashAttribute("success", "Updated product successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        productService.delete(id);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }
}