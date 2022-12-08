package com.example.doit7.coffee.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostCoffeeDto {
    private Long coffeeId;
    private String korname;
    private String engname;
    private int price;



}
