package com.example.doit7.ordercoffee.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatchOrderCoffee {
    private Long ordercoffeeId;
    private Long coffeeId;
    private int quantity;
    private Long orderId;
}
