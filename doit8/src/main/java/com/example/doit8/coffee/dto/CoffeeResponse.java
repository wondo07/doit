package com.example.doit8.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoffeeResponse {
    private Long coffeeId;
    private String korname;
    private String engname;
    private int price;

}
