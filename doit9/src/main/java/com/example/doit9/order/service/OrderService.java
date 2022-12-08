package com.example.doit9.order.service;

import com.example.doit9.order.entity.Order;
import com.example.doit9.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order save(Order order) {
        Order saved = orderRepository.save(order);
        return saved;
    }
}
