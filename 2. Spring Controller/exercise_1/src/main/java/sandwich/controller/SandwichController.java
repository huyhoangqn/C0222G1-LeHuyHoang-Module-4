package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String select() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(name = "condiment") String[] condiment, Model model) {
        StringBuilder result = new StringBuilder();
        if (condiment == null) {
            model.addAttribute("result", " not found ");
        } else {
            for (String s : condiment) {
                result.append(s).append("  ");
            }
            model.addAttribute("result", result.toString());
        }
        return "/result";
    }
}
