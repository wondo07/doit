package com.example.doit7.order.dto;

import com.example.doit7.coffee.entity.Coffee;
import com.example.doit7.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderCoffee {

    private Long coffeeId;
    private int quantity;



    public Coffee getCoffee(){
        Coffee coffee=new Coffee();
        coffee.setCoffeeId(coffeeId);
        return coffee;
    }

}
