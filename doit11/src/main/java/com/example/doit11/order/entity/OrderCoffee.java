package com.example.doit11.order.entity;

import com.example.doit11.coffee.entity.Coffee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ordercoffees")
public class OrderCoffee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordercoffeeId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;

    public void addOrder(Order order){
        this.order=order;
        if (!this.order.getOrderCoffees().contains(this)) {
            this.order.getOrderCoffees().add(this);
        }
    }
    public void addCoffee(Coffee coffee){
        this.coffee=coffee;
        if (!this.coffee.getOrderCoffees().contains(this)) {
            this.coffee.getOrderCoffees().add(this);
        }
    }


}
