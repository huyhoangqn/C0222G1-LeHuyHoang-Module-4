package to_khai_y_te.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import to_khai_y_te.model.MedicalDeclaration;
import to_khai_y_te.service.IMedicalDeclarationService;

@Controller
public class MedicalDeclarationController {
    @Autowired
    @Qualifier("Medical")
    private IMedicalDeclarationService medicalDeclarationService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("medicaldeclaration", new MedicalDeclaration());
        model.addAttribute("years", medicalDeclarationService.years());
        model.addAttribute("genders", medicalDeclarationService.genders());
        model.addAttribute("nationalitys", medicalDeclarationService.nationalitys());
        model.addAttribute("vehicles", medicalDeclarationService.vehicles());
        return "home";
    }

    @PostMapping("/submit")
    public String result(@ModelAttribute("medicaldeclaration") MedicalDeclaration medicalDeclaration, Model model) {
        model.addAttribute("medicaldeclaration", medicalDeclaration);
        return "result";
    }
}
