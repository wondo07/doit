package com.example.doit6.OrderCoffee.repository;


import com.example.doit6.OrderCoffee.entity.OrderCoffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCoffeeRepository extends JpaRepository<OrderCoffee,Long> {
}
