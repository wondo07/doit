//package com.example.doit2.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionAdvice {
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ErrorResponse handleResourceNotFoundException(RuntimeException e) {
//        System.out.println(e.getMessage());
//
//        // ErrorResponse 수정은 실습 과제로 대신합니다.
//
//        return null;
//    }
//}