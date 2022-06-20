package com.codegym.controller;


import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.IMusicService;
import com.codegym.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
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

    @GetMapping("/musics")
    public String home(Model model){
        List<Music> musicList= musicService.findAll();
        System.out.println(musicList.size());
        model.addAttribute("list",musicList);
        return "home";
    }
    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("music", new MusicForm());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createNewMusic(@ModelAttribute MusicForm musicForm, RedirectAttributes redirectAttributes){
        MultipartFile multipartFile= musicForm.getMusic();
        String fileName=multipartFile.getOriginalFilename();
        //Để fileName +fileUpload được ko?
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music= new Music(musicForm.getId(),musicForm.getNameMusic(),musicForm.getAuthor(),musicForm.getCategory(),fileName);
        musicService.save(music);
        redirectAttributes.addFlashAttribute("success", "Create New Music Successfully");
        return "redirect:/musics";
    }
    @GetMapping("/edit{id}")
    public ModelAndView editFormMusic(@PathVariable Long id){
        Music music= musicService.findById(id);
        ModelAndView modelAndView= new ModelAndView("/edit");
        modelAndView.addObject("editFormMusic", music);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editForm(@ModelAttribute("editFormMusic") MusicForm musicForm, RedirectAttributes redirectAttributes){
        MultipartFile multipartFile= musicForm.getMusic();
        String fileName=multipartFile.getOriginalFilename();
        //Để fileName +fileUpload được ko?
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music= new Music(musicForm.getId(),musicForm.getNameMusic(),musicForm.getAuthor(),musicForm.getCategory(),fileName);
        musicService.save(music);
        redirectAttributes.addFlashAttribute("success", "Edit Music Successfully");
        return "redirect:/musics";
    }

    @GetMapping("/delete{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("delete");
        modelAndView.addObject("deleteFormMusic", musicService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete")
    public String deleteMusicForm(@ModelAttribute MusicForm musicForm ,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success","Delete ok");
        musicService.delete(musicForm.getId());
        return "redirect:/musics";
    }

    //Để{id} trước sẽ lỗi
    @GetMapping("/detail{id}")
    ModelAndView showDetail(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("detail");
        mav.addObject("music",musicService.findById(id));
        return mav;
    }
}
