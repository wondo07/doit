package com.example.doit6.OrderCoffee.dto;


import com.example.doit6.coffee.entity.Coffee;
import com.example.doit6.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderCoffeeDto {

    @Positive
    private long orderCoffeeId;
    @Positive
    private long coffeeId;
    @Positive
    private long orderId;

    public Order getOrder(){
        Order order=new Order();
        order.setOrderId(orderId);
        return order;
    }

    public Coffee getCoffee(){
        Coffee coffee=new Coffee();
        coffee.setCoffeeId(coffeeId);
        return coffee;
    }

}
