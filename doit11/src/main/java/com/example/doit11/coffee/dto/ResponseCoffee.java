package com.example.doit11.coffee.dto;

import com.example.doit11.coffee.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ResponseCoffee {
    private Long coffeeId;
    private String korname;
    private String engname;
    private int quantity;
    private int price;
    private Coffee.CoffeeStatus coffeeStatus;

}
