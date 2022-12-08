package com.example.doit7.order.entity;


import com.example.doit7.coffee.entity.Coffee;
import com.example.doit7.order.entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ordercoffees")
public class OrderCoffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordercoffeeId;


    @Column
    private int quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;
}
