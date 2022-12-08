package com.example.doit8.order.service;

import com.example.doit8.order.entity.Order;
import com.example.doit8.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public Order save(Order order) {
        Order saved = orderRepository.save(order);
        return saved;
    }

    public Order get(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        return order;
    }
}
