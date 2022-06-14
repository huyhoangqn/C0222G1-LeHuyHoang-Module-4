package convert.controller;

import convert.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    private ICurrencyService currencyService;

    @GetMapping(value = "/input")
    public String input() {
        return "input";
    }

    @PostMapping(value = "/currency")
    public String currency(@RequestParam float usd, @RequestParam float rate, Model model) {
        model.addAttribute("currencyResult", currencyService.currencyResult(usd, rate));
        return "result";
    }
}
