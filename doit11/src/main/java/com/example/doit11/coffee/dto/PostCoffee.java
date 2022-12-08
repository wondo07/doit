package com.example.doit11.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostCoffee {

    private String korname;
    private String engname;
    private int quantity;
    private int price;


}
