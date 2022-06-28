package com.codegym.excercise.controller;

import com.codegym.excercise.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CartController {
    @GetMapping("/cart-list")
    public String showCart(@SessionAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "showcart";
    }
}
