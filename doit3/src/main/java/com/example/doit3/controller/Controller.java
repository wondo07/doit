package com.example.doit3.controller;

import com.example.doit3.dto.Patchdto;
import com.example.doit3.dto.Postdto;
import com.example.doit3.entity.entity;
import com.example.doit3.exception.ErrorResponse;
import com.example.doit3.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
@Validated
@Slf4j
public class Controller {

    private final MemberService memberService;

    public Controller(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/post")
    public ResponseEntity post(@Valid @RequestBody Postdto postdto){
        entity Entity = memberService.post(postdto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Entity);


    }

//    @ExceptionHandler
//    public ResponseEntity handleException(MethodArgumentNotValidException e) {
//        // (1)
//        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//
//        // (2)
//        List<ErrorResponse.FieldError> errors =
//                fieldErrors.stream()
//                        .map(error -> new ErrorResponse.FieldError(
//                                error.getField(),
//                                error.getRejectedValue(),
//                                error.getDefaultMessage()))
//                        .collect(Collectors.toList());
//
//        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
//    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        entity Entity = memberService.get(id);
        return (Entity != null)?
                ResponseEntity.status(HttpStatus.OK).body(Entity):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<entity>> all(){
        ArrayList<entity> Entity = memberService.getall();
       return (Entity != null)?
               ResponseEntity.status(HttpStatus.OK).body(Entity):
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        entity Entity = memberService.delete(id);
        return (Entity != null)?
                ResponseEntity.status(HttpStatus.OK).body(Entity):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity patch(@PathVariable Long id, @RequestBody Patchdto patchdto){
        entity Entity=memberService.patch(id,patchdto);
        return (Entity != null)?
                ResponseEntity.status(HttpStatus.OK).body(Entity):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/transaction-test")
    public ResponseEntity<List<entity>> transactiontest(@RequestBody List<Postdto> dtos){
        List<entity> entityList  = memberService.createArticles(dtos);
        return (entityList != null)?
                ResponseEntity.status(HttpStatus.OK).body(entityList):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
