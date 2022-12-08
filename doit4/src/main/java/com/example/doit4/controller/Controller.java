package com.example.doit4.controller;


import com.example.doit4.dto.PostDto;
import com.example.doit4.dto.UpdateDto;
import com.example.doit4.entity.entity;
import com.example.doit4.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class Controller {

    private final ArticleService articleService;

    public Controller(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/input")
    public ResponseEntity input(@RequestBody PostDto postDto){
        entity Entity = articleService.input(postDto);
        return (Entity !=null)?
                ResponseEntity.status(HttpStatus.OK).body(Entity):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        entity Entity=articleService.get(id);
        return (Entity !=null)?
                ResponseEntity.status(HttpStatus.OK).body(Entity):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping
    public ResponseEntity getlist(){
        List<entity> Entity=articleService.getlist();
        return (Entity !=null)?
                ResponseEntity.status(HttpStatus.OK).body(Entity):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity patch(@PathVariable Long id, @RequestBody UpdateDto updateDto){
        entity Entity = articleService.patch(id,updateDto);
        return (Entity !=null)?
                ResponseEntity.status(HttpStatus.OK).body(Entity):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        entity Entity = articleService.delete(id);
        return (Entity !=null)?
                ResponseEntity.status(HttpStatus.OK).body(Entity):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
