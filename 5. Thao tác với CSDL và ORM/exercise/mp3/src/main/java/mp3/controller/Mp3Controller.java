package mp3.controller;

import mp3.model.Mp3;
import mp3.service.IMp3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Mp3Controller {
    @Autowired
    private IMp3Service iMp3Service;

    @GetMapping
    public String home(Model model){

        model.addAttribute("mp3List",iMp3Service.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("mp3",new Mp3());
        return "/create";
    }

    @PostMapping("/create")
    public String save(Mp3 mp3){
        iMp3Service.create(mp3);
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("mp3",iMp3Service.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String upgrade(Mp3 mp3){
        iMp3Service.update(mp3);
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id , Model model){
        model.addAttribute("mp3",iMp3Service.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String remove(Mp3 mp3){
        iMp3Service.delete(mp3.getId());
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(String name,Model model){
        model.addAttribute("mp3List",iMp3Service.search(name));
        return "/list";
    }
}
