package com.example.doit6.OrderCoffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCoffeeResponseDto {

    private Long orderCoffeeId;
    private Long coffeeId;
    private Long orderId;
}
