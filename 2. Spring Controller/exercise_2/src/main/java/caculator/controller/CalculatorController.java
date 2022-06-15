package caculator.controller;

import caculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CalculatorController {
    @Autowired
    @Qualifier("calculator")
    ICalculatorService calculatorService;

    @GetMapping("/")
    public String caculator() {
        return "index";
    }

    @PostMapping("/calculator")
    public String result(@RequestParam Map<String, String> calculator, Model model) {
        model.addAttribute("number1", calculator.get("number1"));
        model.addAttribute("number2", calculator.get("number2"));
        model.addAttribute("result", calculatorService.calculator(calculator));
        return "index";
    }
}
