package com.example.doit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/hi")
public class FirstController {

    @GetMapping("/hi")
    public String nicetomeet(Model model){
        model.addAttribute("user","김원도");
        return "greeting";
    }
//    @GetMapping("/1")
//    public String bye(){
//    return "goodbye";
//    }

}
