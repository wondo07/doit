package com.example.doit8.coffee.entity;


import com.example.doit8.order.entity.OrderCoffee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter

@NoArgsConstructor
@Table(name = "coffees")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coffeeId;
    @Column
    private String korname;
    @Column
    private String engname;
    @Column
    private int price;

    @OneToMany(mappedBy = "coffee",cascade = CascadeType.PERSIST)
    List<OrderCoffee> orderCoffeeList=new ArrayList<>();


    public void addOrderCoffee(OrderCoffee orderCoffee) {
        this.orderCoffeeList.add(orderCoffee);
        if (orderCoffee.getCoffee() != this) {
            orderCoffee.addCoffee(this);
        }
    }

}
