package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import com.codegym.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    @Qualifier("studentService")
    private IStudentService iStudentService;

//    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @GetMapping(value = "/list")
    public String getAllStudent(Model model) {
        List<Student> list = iStudentService.getAll();
        model.addAttribute("listStudent", list);
        return "list";
    }

    @GetMapping("/create")
    public String movePageCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@RequestParam("codeStudent")Integer codeStudent,
                                @RequestParam("nameStudent")String nameStudent,
                                @RequestParam("point")Double point,
                                @RequestParam("gender")Integer gender,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        iStudentService.save(new Student(codeStudent,nameStudent,point,gender));
//        List<Student> list = iStudentService.getAll();
//        model.addAttribute("listStudent", list);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/list";
    }
    @GetMapping("/detail/{codeStudent}")
    public String moveDetail(@PathVariable("codeStudent")Integer codeStudent) {
        System.out.println(codeStudent);
        return "detail";
    }

}
