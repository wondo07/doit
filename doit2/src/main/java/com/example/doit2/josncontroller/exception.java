//package com.example.doit2.josncontroller;
//
//import org.apache.catalina.filters.ExpiresFilter;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.persistence.Column;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@ControllerAdvice
//public class exception {
//    @ExceptionHandler(value = Exception.class)
//    public Map<String,String> handleException(Exception e){
//        Map<String,String> map=new HashMap<>();
//        map.put("errMsg",e.getMessage());
//        return map;
//    }
//}
