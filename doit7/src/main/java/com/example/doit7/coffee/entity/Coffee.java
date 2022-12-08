package com.example.doit7.coffee.entity;


import com.example.doit7.order.entity.OrderCoffee;
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
@AllArgsConstructor
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

    @OneToMany(mappedBy = "coffee")
    List<OrderCoffee> orderCoffeeList=new ArrayList<>();

}
