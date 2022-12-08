package com.example.doit10.coffee.dto;


import com.example.doit10.coffee.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCoffee {

    private Long coffeeId;
    private String korname;
    private String engname;
    private int quantity;
    private Coffee.CoffeeStatus coffeeStatus;
}
