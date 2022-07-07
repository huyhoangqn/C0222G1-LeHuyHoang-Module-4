package com.example.demo.controller;

import com.example.demo.service.ITypeOfCustomerService;
import com.example.demo.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/show")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ITypeOfCustomerService typeOfCustomerService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("typeCus", typeOfCustomerService.findAll());
        return "customer/showCustomer";
    }
}
