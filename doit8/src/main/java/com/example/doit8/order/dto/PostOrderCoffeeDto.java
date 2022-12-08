package com.example.doit8.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderCoffeeDto {

    @Positive
    private long coffeeId;

    @Positive
    private Integer quantity;


}
