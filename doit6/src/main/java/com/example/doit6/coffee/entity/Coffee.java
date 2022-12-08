package com.example.doit6.coffee.entity;


import com.example.doit6.OrderCoffee.entity.OrderCoffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    @Column
    private int quantity;

    @OneToMany(mappedBy = "coffee",cascade =CascadeType.PERSIST)
    List<OrderCoffee> orderCoffeeList=new ArrayList<>();

}
