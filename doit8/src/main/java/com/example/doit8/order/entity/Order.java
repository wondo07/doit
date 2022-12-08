package com.example.doit8.order.entity;


import com.example.doit8.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST)
    List<OrderCoffee> orderCoffeeList = new ArrayList<>();

    public void addOrderCoffee(OrderCoffee orderCoffee) {
        this.orderCoffeeList.add(orderCoffee);
        if (orderCoffee.getOrder() != this) {
            orderCoffee.addOrder(this);
        }
    }

}
