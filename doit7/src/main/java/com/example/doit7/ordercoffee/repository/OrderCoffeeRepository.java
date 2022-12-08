package com.example.doit7.ordercoffee.repository;

import com.example.doit7.order.entity.OrderCoffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCoffeeRepository extends JpaRepository<OrderCoffee,Long> {
}
