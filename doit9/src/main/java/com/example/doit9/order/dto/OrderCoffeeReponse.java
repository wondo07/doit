package com.example.doit9.order.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCoffeeReponse {


    private long coffeeId;
    private String korName;
    private String engName;
    private Integer price;


}
