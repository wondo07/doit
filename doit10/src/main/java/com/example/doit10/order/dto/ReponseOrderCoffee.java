package com.example.doit10.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReponseOrderCoffee {
    private Long coffeeId;
    private String korname;
    private String engname;
    private int quantity;

}
