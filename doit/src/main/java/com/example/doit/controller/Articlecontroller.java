package com.example.doit.controller;

import com.example.doit.dto.ArticleForm;
import com.example.doit.entity.Article;
import com.example.doit.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller //뷰 템플릿 페이지를 반환
@Slf4j  //로깅을 위한 어너테이션
public class Articlecontroller {

    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/input")
    public String newarticle(){
        return "articles/input";
    }

    @PostMapping("/articles/create")
    public String createarticle(ArticleForm articleForm){
        log.info(articleForm.toString());
        // dto -> Article
        Article entityarticle=articleForm.toEntity();
        log.info(entityarticle.toString());
        // repository에 entity를 저장
        Article saved = articleRepository.save(entityarticle);
        log.info(saved.toString());
    return "redirect:/articles/tableall";
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = "+id );

        // 1. id로 데이터를 가져옴
        Article entity=articleRepository.findById(id).orElse(null);
        // 2. 가져온 데이터를 모델에 등록!
        model.addAttribute("article",entity);
        // 3. 보여줄 페이지를 설정!
        return "articles/table";
    }

    @GetMapping("/articles/tableall")
    public String index(Model model){
        // 1. 모든 article를 가져온다.
        ArrayList<Article> articlelist=articleRepository.findAll();
        // 2. 가져온 Article 묶음을 뷰로 설정
        model.addAttribute("articlelist",articlelist);
        // 3. 뷰 페이지 설정!
        return "articles/tableall";
    }

    @GetMapping("/articles/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        // 수정할 데이터 가져오기
        Article entity=articleRepository.findById(id).orElse(null);
        model.addAttribute("article",entity);
        // 모델에 데이터를 등록!
        return "articles/edit";
    }

    @PostMapping("/articles/edit")
    public String update(ArticleForm dto){
        Article entity = dto.toEntity();
        // 기존의 데이터에서 엔티티를 가져온다
        Article target = articleRepository.findById(entity.getId()).orElse(null);
        // 기존 데이터에 값을 수정한다.
        if(target!=null){
            articleRepository.save(entity);
        }
        return "redirect:/articles/tableall";
    }

    @GetMapping("/articles/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        Article entity = articleRepository.findById(id).orElse(null);
        if(entity != null){
            articleRepository.delete(entity);
        }
        rttr.addFlashAttribute("msg","삭제가 완료되었습니다");
        return "redirect:/articles/tableall";
    }

}
