package com.example.doit6.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCoffeeDto {

    private Long coffeeId;
    private String korname;
    private String engname;
    private int price;
    private int quantity;
}
