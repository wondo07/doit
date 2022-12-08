package com.example.doit11.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseOrderCoffee {

    private Long coffeeId;
    private String korname;
    private String engname;
    private Integer quantity;
    private Integer price;
}
