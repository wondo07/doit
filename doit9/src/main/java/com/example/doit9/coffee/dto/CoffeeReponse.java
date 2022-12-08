package com.example.doit9.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;

@Getter
@AllArgsConstructor
public class CoffeeReponse {

    private long coffeeId;

    private String korname;

    private String engname;

    private int quantity;

    private int price;
}
