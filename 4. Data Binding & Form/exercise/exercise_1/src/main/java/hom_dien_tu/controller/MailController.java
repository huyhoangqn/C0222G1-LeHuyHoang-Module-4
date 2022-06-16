package hom_dien_tu.controller;

import hom_dien_tu.model.Mail;
import hom_dien_tu.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {
    @Autowired
    @Qualifier("mail")
    private IMailService mailService;

    @GetMapping(value = "/")
    public String getMail(Model model) {
        model.addAttribute("mail", new Mail());
        model.addAttribute("languages", mailService.languages());
        model.addAttribute("pageSizes", mailService.pageSizes());
        return "home";
    }

    @PostMapping(value = "/mail")
    public String createMail(@ModelAttribute("mail") Mail mail, Model model) {
        model.addAttribute("mail", mail);
        return "mail";
    }
}
