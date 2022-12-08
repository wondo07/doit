package com.example.doit10.coffee.entity;

import com.example.doit10.order.entity.OrderCoffee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="coffees")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coffeeId;
    @Column
    private String korname;
    @Column
    private String engname;
    @Column
    private int quantity;

    @Column
    @Enumerated(value = EnumType.STRING)
    private CoffeeStatus coffeeStatus = CoffeeStatus.COFFEE_FOR_SALE;

    @OneToMany(mappedBy = "coffee")
    List<OrderCoffee> orderCoffees=new ArrayList<>();


    public void patch(Coffee coffee) {
        this.engname= coffee.engname;
        this.korname= coffee.korname;
        this.quantity=coffee.quantity;
    }
    public enum CoffeeStatus{
        COFFEE_FOR_SALE("판매중"),
        COFFEE_SOLD_OUT("판매 중지");

        @Getter
        private String coffeeStatus;

        CoffeeStatus(String coffeeStatus) {
            this.coffeeStatus = coffeeStatus;
        }
    }

}
