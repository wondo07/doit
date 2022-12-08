package com.example.doit9.order.entity;

import com.example.doit9.coffee.entity.Coffee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name ="coffee_id")
    private Coffee coffee;



    public void addOrder(Order order){
        this.order=order;
        if (!this.order.getOrderCoffeeList().contains(this)) {
            this.order.getOrderCoffeeList().add(this);
        }
    }

    public void addCoffee(Coffee coffee){
        this.coffee=coffee;
        if(!this.coffee.getOrderCoffeeList().contains(this)){
            this.coffee.getOrderCoffeeList().add(this);
        }
    }
}
