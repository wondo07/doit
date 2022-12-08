package com.example.doit2.controller;

import com.example.doit2.dto.dto;
import com.example.doit2.entity.entity;
import com.example.doit2.repository.ArticleRepository;
import com.example.doit2.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/input")
    public String input(){
        return "articles/input";
    }

    @PostMapping("/articles/create")
    public String getinput(dto Dto){
        entity Entity = Dto.toEntity();
        entity saved = articleRepository.save(Entity);
        return "redirect:/articles/tableall";
    }

    @GetMapping("/articles/tableall")
    public String tableall(Model model){
        ArrayList<entity> entitylist = articleRepository.findAll();
        model.addAttribute("article",entitylist);
        return "articles/tableall";
    }

    @GetMapping("/articles/table/{id}")
    public String table(Model model,@PathVariable Long id){
         entity Entity = articleRepository.findById(id).orElse(null);
         model.addAttribute("article",Entity);
         return "articles/table";
    }

    @GetMapping("/articles/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        entity Entity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article",Entity);
        return "articles/edit";
    }
    @PostMapping("/articles/edit")
    public String geteidt(dto Dto){
        entity Entity = Dto.toEntity();
        if(Entity !=null){
            articleRepository.save(Entity);
        }
        return "redirect:/articles/tableall";
    }

    @GetMapping("/articles/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        entity Entity = articleRepository.findById(id).orElse(null);
        if (Entity != null){
            articleRepository.delete(Entity);
        }
        rttr.addFlashAttribute("msg","삭제가 완료되었습니다.");
        return "redirect:/articles/tableall";
    }



}
