package com.example.doit5.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCoffeedto {
    @Positive
    private long coffeeId;

    @Positive
    private int quantity;
}
