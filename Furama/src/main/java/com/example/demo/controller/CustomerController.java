package com.example.demo.controller;

import com.example.demo.bean.Customer;
import com.example.demo.service.ITypeOfCustomerService;
import com.example.demo.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ITypeOfCustomerService typeOfCustomerService;

    @GetMapping("/show")
    public ModelAndView displayPageShow(@PageableDefault(value = 1) Pageable pageable) {
        Page<Customer> customers = customerService.showAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/showCustomer");
        if (customers.getContent().size() == 0) {
            modelAndView.addObject("message", "Chưa có khách hàng");
        } else {
            modelAndView.addObject("customers", customers);
        }
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String displayPageCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("typeCus", typeOfCustomerService.findAll());
        return "customer/createCustomer";
    }

    @PostMapping(value = "/create")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("typeCus", typeOfCustomerService.findAll());
            return "customer/createCustomer";
        } else {
            redirectAttributes.addFlashAttribute("smg", "Create customer: " + customer.getCustomerName() + " success.");
            String idCus = "KH-" + ((int) (Math.random() * 10000));
            customer.setCustomerId(idCus);
            customerService.save(customer);
            return "redirect:/customer/show";
        }
    }

    @GetMapping(value = "/edit/{id}")
    public String showPageUpdate(@PathVariable String id, Model model) {
        model.addAttribute("typeCus", typeOfCustomerService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "customer/updateCustomer";
    }

    @PostMapping(value = "/edit")
    public String updateCustomer(@ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("typeCus", typeOfCustomerService.findAll());
            return "customer/createCustomer";
        } else {
            redirectAttributes.addFlashAttribute("smg", "Update customer: " + customer.getCustomerName() + " success.");
            customerService.save(customer);
            return "redirect:/customer/show";
        }
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable String id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id);
        redirectAttributes.addFlashAttribute("msg", "Delete customer: " + customer.getCustomerName() + " success.");
        customerService.delete(customer);
        return "redirect:/customer/show";
    }

    @GetMapping(value = "/search")
    public ModelAndView showListSearch(@PageableDefault(value = 1) Pageable pageable, @RequestParam("search") String name) {
        Page<Customer> customers = customerService.findByName(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("customer/showCustomer");
        modelAndView.addObject("customers", customers);
        if (customers == null) {
            modelAndView.addObject("msg", "Not found.");
        }
        return modelAndView;
    }
}
