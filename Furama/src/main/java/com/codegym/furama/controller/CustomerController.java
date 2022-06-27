package com.codegym.furama.controller;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.service.DuplicateIDException;
import com.codegym.furama.service.impl.CustomerService;
import com.codegym.furama.service.impl.CustomerTypeService;
import com.codegym.furama.service.impl.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @Autowired
    private GenderService genderService;

    @GetMapping("/customer-list")
    public String list(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Customer> list = customerService.findAll(PageRequest.of(page, 1));
        model.addAttribute("customers", list);
        return "/customer/list";
    }

    @GetMapping("/customer-create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("genders", genderService.findAll());
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/customer-save")
    public String save(@Valid Customer customer, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        try {
            if (bindingResult.hasErrors()) {
                model.addAttribute("genders", genderService.findAll());
                model.addAttribute("customerTypes", customerTypeService.findAll());
                return "/customer/create";
            } else {
                if (!customerService.existId(customer.getCustomerId())) {
                    customerService.create(customer);
                    redirectAttributes.addFlashAttribute("success", "Create complete");
                    return "redirect:/customer-list";
                } else {
                    throw new DuplicateIDException();
                }
            }
        } catch (DuplicateIDException e) {
            return "/customer/inputs-not-acceptable";
        }
    }
}
