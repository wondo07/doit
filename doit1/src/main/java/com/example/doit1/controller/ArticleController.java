package com.example.doit1.controller;

import com.example.doit1.dto.ArticleDto;
import com.example.doit1.entity.ArticleEntity;
import com.example.doit1.respository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
@Slf4j
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles/input")
    public String input(){
        return "templates/articles/input";
    }

    @PostMapping("/articles/create")
    public String create(ArticleDto articleDto){
        log.info(articleDto.toString());
        ArticleEntity articleEntity = articleDto.toEntity();
        log.info(articleEntity.toString());
        ArticleEntity saved=articleRepository.save(articleEntity);
        log.info(saved.toString());
        return "redirect:/articles/show";
    }
    @GetMapping("/articles/show")
    public String show(Model model){
        ArrayList<ArticleEntity> articlelist = articleRepository.findAll();
        model.addAttribute("articlelist",articlelist);
        return "templates/articles/show";
    }

    @GetMapping("/articles/{id}")
    public String table(@PathVariable Long id, Model model){
        ArticleEntity entity = articleRepository.findById(id).orElse(null);
        log.info("로그확인 " + entity.toString());
        model.addAttribute("article",entity);
        return "templates/articles/table";
    }



}
