package com.codegym.excercise.controller;

import com.codegym.excercise.model.Cart;
import com.codegym.excercise.model.Product;
import com.codegym.excercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ShopController {
    @Autowired
    private IProductService productService;

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shoplist";
    }

    @ModelAttribute("cart")
    public Cart getCart(){
        return new Cart();
    }

    @GetMapping("/view/{productId}")
    public String detailProduct(@PathVariable String productId, Model model) {
        Optional<Product> productOptional = productService.findById(productId);
        if (!productOptional.isPresent()) {
            return "/error.404";
        } else {
            model.addAttribute("product", productOptional.get());
            return "view";
        }
    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable String productId, @ModelAttribute("cart") Cart cart) {
        Optional<Product> productOptional = productService.findById(productId);
        if (!productOptional.isPresent()) {
            return "/error.404";
        } else {
            cart.addProduct(productOptional.get());
            return "redirect:/cart-list";
        }
    }
}
