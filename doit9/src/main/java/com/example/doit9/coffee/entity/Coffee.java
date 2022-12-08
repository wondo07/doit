package com.example.doit9.coffee.entity;


import com.example.doit9.order.entity.OrderCoffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coffeeId;
    @Column
    private String korname;
    @Column
    private String engname;
    @Column
    private int quantity;
    @Column
    private int price;

    @OneToMany(mappedBy = "ordercoffee_id")
    List<OrderCoffee> orderCoffeeList=new ArrayList<>();
}
