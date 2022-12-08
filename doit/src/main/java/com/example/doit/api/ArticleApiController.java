package com.example.doit.api;


import com.example.doit.dto.ArticleForm;
import com.example.doit.entity.Article;
import com.example.doit.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController // json데이터 반환
public class ArticleApiController {

    @Autowired //DI
    private ArticleRepository articleRepository;

    //GET
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleRepository.findAll();
    }
    @GetMapping("/api/articles/{id}")
    public Article index1(@PathVariable Long id){
        return articleRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto){  //@RequestBody JSON 데이터 받
        Article entity = dto.toEntity();
        return articleRepository.save(entity);
    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> patch(@RequestBody ArticleForm dto, @PathVariable Long id){
       Article entity  = dto.toEntity();
       Article exentity = articleRepository.findById(id).orElse(null);
       if(id != entity.getId() || exentity ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
       }
       exentity.patch(entity);
       Article saved = articleRepository.save(entity);
       return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article entity= articleRepository.findById(id).orElse(null);
        articleRepository.delete(entity);
        if(entity ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        articleRepository.delete(entity);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
