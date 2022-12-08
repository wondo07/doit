package com.example.doit6.OrderCoffee.entity;

import com.example.doit6.coffee.entity.Coffee;
import com.example.doit6.order.entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "OrderCoffees")
public class OrderCoffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCoffeeId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="coffee_id")
    private Coffee coffee;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;

}
