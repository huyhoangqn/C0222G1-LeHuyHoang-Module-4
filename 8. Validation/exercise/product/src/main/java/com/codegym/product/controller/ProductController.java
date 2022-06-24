package com.codegym.product.controller;

import com.codegym.product.dto.ProductDTO;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String getAllProduct(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<ProductDTO> list = productService.findAllProduct(PageRequest.of(page, 2));
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("products", list);
        return "list";
    }

}
