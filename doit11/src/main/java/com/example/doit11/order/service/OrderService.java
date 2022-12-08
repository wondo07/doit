package com.example.doit11.order.service;

import com.example.doit11.order.entity.Order;
import com.example.doit11.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saved(Order order) {
       Order saved = orderRepository.save(order);
       return saved;
    }

    public Order patch(Long orderId, Order order) {
        Order oldorder = orderRepository.findById(orderId).orElse(null);
        oldorder.patch(order);
        orderRepository.save(oldorder);
        return oldorder;
    }


    public Order delete(Long orderId) {
       Order order = orderRepository.findById(orderId).orElse(null);
       orderRepository.delete(order);
       return order;
    }

    public Order get(Long orderId) {
       Order order = orderRepository.findById(orderId).orElse(null);
       return order;
    }
}
