package com.example.code2.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Table;

@Getter
@AllArgsConstructor
@Table(schema = "ORDER_COFFEE")
public class CoffeeRef {
    private Long coffeeId;
    private int quantity;
}
