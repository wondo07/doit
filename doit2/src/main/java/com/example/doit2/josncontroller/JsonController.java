package com.example.doit2.josncontroller;

import com.example.doit2.dto.dto;
import com.example.doit2.entity.entity;
import com.example.doit2.repository.ArticleRepository;
import com.example.doit2.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
public class JsonController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public ResponseEntity<ArrayList<entity>> article() {
        return articleService.article();
    }

    @PostMapping("/articles/input")
    public ResponseEntity<entity> input(@RequestBody dto Dto) {
        entity Entity = articleService.save(Dto);
        return (Entity != null) ?
                ResponseEntity.status(HttpStatus.OK).body(Entity) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PatchMapping("/articles/edit/{id}")
    public ResponseEntity<entity> edit(@RequestBody dto Dto, @PathVariable Long id) {
        entity Entity = articleService.patch(Dto, id);
        return (Entity != null) ?
                ResponseEntity.status(HttpStatus.OK).body(Entity) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/articles/delete/{id}")
    public ResponseEntity<entity> delete(@PathVariable Long id) {
        entity Entity = articleService.delete(id);
        return (Entity != null) ?
                ResponseEntity.status(HttpStatus.OK).body(Entity) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

//
//    @ExceptionHandler
//    public ResponseEntity handleException(MethodArgumentNotValidException e) {
//        // (1)
//        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//
//        // (2)
//        return new ResponseEntity<>(fieldErrors, HttpStatus.BAD_REQUEST);
//    }


    @PostMapping("/articles/transaction-test")
    public ResponseEntity<List<entity>> transactiontest(@RequestBody List<dto> dtos){
        List<entity> entityList  = articleService.createArticles(dtos);
        return (entityList != null)?
                ResponseEntity.status(HttpStatus.OK).body(entityList):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}