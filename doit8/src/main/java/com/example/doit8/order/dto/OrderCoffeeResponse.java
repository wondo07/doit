package com.example.doit8.order.dto;


import lombok.*;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCoffeeResponse {

    private long coffeeId;
    private String korName;
    private String engName;
    private Integer price;


}
