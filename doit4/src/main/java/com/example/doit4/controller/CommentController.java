package com.example.doit4.controller;

import com.example.doit4.dto.CommentDto;
import com.example.doit4.dto.UpdateComment;
import com.example.doit4.dto.UpdateDto;
import com.example.doit4.entity.comment;
import com.example.doit4.entity.entity;
import com.example.doit4.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/input")
    public ResponseEntity input1(@RequestBody CommentDto commentDto){
       comment Comment = commentService.input(commentDto);
       return (Comment != null)?
               ResponseEntity.status(HttpStatus.OK).body(Comment):
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/{articleId}")
    public ResponseEntity patch1(@PathVariable Long articleId, @RequestBody UpdateComment updateComment){
        comment Comment = commentService.patch1(articleId,updateComment);
        return (Comment != null)?
                ResponseEntity.status(HttpStatus.OK).body(Comment):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<List<CommentDto>> get(@PathVariable Long articleId){
        List<CommentDto> Comment=commentService.get(articleId);
        return (Comment != null)?
                ResponseEntity.status(HttpStatus.OK).body(Comment):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping
    public ResponseEntity getlist(){
        List<comment> commenlist= commentService.getlist();
        return (commenlist != null)?
                ResponseEntity.status(HttpStatus.OK).body(commenlist):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @DeleteMapping("/{articleId}")
    public ResponseEntity delete(@PathVariable Long articleId){
        comment Comment = commentService.delete(articleId);
        return (Comment !=null)?
                ResponseEntity.status(HttpStatus.OK).body(Comment):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }



}
