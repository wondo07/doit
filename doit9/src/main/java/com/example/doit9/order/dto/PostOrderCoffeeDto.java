package com.example.doit9.order.dto;


import com.example.doit9.coffee.entity.Coffee;
import com.example.doit9.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PostOrderCoffeeDto {

    private long ordercoffeeId;
    private Long orderId;
    private Long coffeeId;
    private int quantity;

    public Order getOrder(){
        Order order = new Order();
        order.setOrderId(orderId);
        return order;
    }

    public Coffee getCoffee(){
        Coffee coffee=new Coffee();
        coffee.setCoffeeId(coffeeId);
        return coffee;
    }



}
