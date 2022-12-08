package com.example.doit9.coffee.dto;

import com.example.doit9.order.entity.OrderCoffee;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCoffee {

    private long coffeeId;

    private String korname;

    private String engname;

    private int quantity;

    private int price;



}
