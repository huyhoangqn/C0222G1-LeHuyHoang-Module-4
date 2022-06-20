package com.codegym.controller;


import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:upload_file.properties")
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IMusicService musicService;

    @GetMapping("/")
    public String home(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("list", musicList);
        return "home";
    }

    @GetMapping("/create")
    public String createForm(Model model) {

        model.addAttribute("musicForm", new MusicForm());
        return "create";
    }

    //    @PostMapping("/create")
//    public String createNewMusic(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
//        music = new Music(music.getId(), music.getNameMusic(), music.getAuthor(), music.getCategory(), music.getMusic());
//        musicService.save(music);
//        redirectAttributes.addFlashAttribute("success", "Create New Music Successfully");
//        return "redirect:/";
//    }
    @PostMapping("/create")
    public String createNewMusic(@ModelAttribute MusicForm musicForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = musicForm.getMusic();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(musicForm.getId(), musicForm.getNameMusic(), musicForm.getAuthor(), musicForm.getCategory(), fileName);
        musicService.save(music);
        redirectAttributes.addFlashAttribute("success", "Create New Music Successfully");
        return "redirect:/";
    }
}
