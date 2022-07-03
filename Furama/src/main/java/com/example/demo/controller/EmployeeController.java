package com.example.demo.controller;

import com.example.demo.bean.*;
import com.example.demo.service.IDivisionService;
import com.example.demo.service.IEducationDegreeService;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IPositionService;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private UserService userService;

    @ModelAttribute("education")
    public Iterable<EducationDegree> educationDegrees() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("position")
    public Iterable<Position> positions() {
        return positionService.findAll();
    }

    @ModelAttribute("division")
    public Iterable<Division> divisions() {
        return divisionService.findAll();
    }

    @GetMapping(value = "/show")
    public ModelAndView showPageListEmployee(@PageableDefault(value = 1) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("employee/showEmployee");
        if (employees.getContent().size() == 0) {
            modelAndView.addObject("msg", "Chưa có nhân viên nào.");
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String showPageCreateEmployee(Model model) {
        model.addAttribute("employeeUser", new EmployeeUser());
        return "employee/createEmployee";
    }

    @PostMapping(value = "/create")
    public String saveEmployee(@Validated @ModelAttribute EmployeeUser employeeUser, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "employee/createEmployee";
        } else {
            if (userService.checkUserName(employeeUser.getUserName())) {
                model.addAttribute("msgUserName", "Tên đăng nhập đã tồn tại.");
                return "employee/createEmployee";
            } else {
                redirectAttributes.addFlashAttribute("msg", "Create employee: " + employeeUser.getName() + " success.");
                User user;
                user = new User(employeeUser.getUserName(), employeeUser.getPassWord());

                String idEmployee = "NV-" + ((int) (Math.random() * 10000));
                Employee employee = new Employee(idEmployee, employeeUser.getName(), employeeUser.getBirthday(), employeeUser.getIdCard(),
                        employeeUser.getSalary(), employeeUser.getPhone(), employeeUser.getEmail(), employeeUser.getAddress(),
                        employeeUser.getPosition(), employeeUser.getEducationDegree(), employeeUser.getDivision(), user);
                userService.save(user);
                employeeService.save(employee);
                return "redirect:/employee/show";
            }
        }
    }
}
