package com.example.demo.controller;

import com.example.demo.bean.RentType;
import com.example.demo.bean.Service;
import com.example.demo.bean.ServiceType;
import com.example.demo.service.impl.RentTypeService;
import com.example.demo.service.impl.ServiceService;
import com.example.demo.service.impl.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private RentTypeService rentTypeService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @ModelAttribute("rentType")
    public Iterable<RentType> rentTypes() {
        return rentTypeService.findAll();
    }

    @ModelAttribute("serviceType")
    public Iterable<ServiceType> serviceTypes() {
        return serviceTypeService.findAll();
    }

    @GetMapping(value = "/showAll")
    public ModelAndView showAll(@PageableDefault(value = 3) Pageable pageable) {
        Page<Service> services = serviceService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("service/showAllService");
        if (services.getContent().size() == 0) {
            modelAndView.addObject("msg", "Chưa có dịch vụ nào");
            return modelAndView;
        }
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping(value = "/search")
    public ModelAndView showListSearch(@PageableDefault(value = 9) Pageable pageable, @RequestParam("search") String name) {
        Page<Service> services = serviceService.findByName(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("service/showAllService");
        if (services.getContent().size() == 0) {
            modelAndView.addObject("msg", "Not found.");
            return modelAndView;
        }
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping(value = "/showDetail/{id}")
    public String showDetail(@PathVariable String id, Model model) {
        Service service = serviceService.findById(id);
        model.addAttribute("service", service);
        return "service/showDetailService";
    }

    @GetMapping(value = "/create")
    public String showPageCreateService(Model model) {
        model.addAttribute("service", new Service());
        return "service/createService";
    }

    @PostMapping(value = "/create")
    public String save(@Validated @ModelAttribute Service service, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "service/createService";
        } else {
            redirectAttributes.addFlashAttribute("msg", "Create service : " + service.getServiceName() + " success.");
            String idService = "DV-" + ((int) (Math.random() * 10000));
            service.setServiceId(idService);
            serviceService.save(service);
            return "redirect:/service/showAll";
        }
    }

    @GetMapping(value = "/update/{id}")
    public String showPageUpdate(@PathVariable String id, Model model) {
        Service service = serviceService.findById(id);
        model.addAttribute("service", service);
        return "service/updateService";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Update service : " + service.getServiceName() + " success.");
        serviceService.save(service);
        return "redirect:/service/showAll";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable String id, RedirectAttributes redirectAttributes) {
        Service service = serviceService.findById(id);
        redirectAttributes.addFlashAttribute("msg", "Delete customer: " + service.getServiceName() + "success.");
        serviceService.delete(service);
        return "redirect:/service/showAll";
    }
}
