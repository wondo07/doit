package com.example.doit6.coffee.dto;


import com.example.doit6.OrderCoffee.entity.OrderCoffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostCoffee {

    private Long coffeeId;
    private String korname;
    private String engname;
    private int price;
    private int quantity;

    public OrderCoffee getOrderCoffee(){
        OrderCoffee orderCoffee=new OrderCoffee();
        orderCoffee.setOrderCoffeeId(coffeeId);
        return orderCoffee;
    }

}
