package com.example.code2.coffee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter

public class Coffee {

    @Id
    private Long coffeeId;
    private String KorName;
    private String engName;
    private int price;
    private String coffeeCode;


}
