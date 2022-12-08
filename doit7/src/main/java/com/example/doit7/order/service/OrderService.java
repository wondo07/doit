package com.example.doit7.order.service;

import com.example.doit7.order.entity.Order;
import com.example.doit7.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order post(Order order) {
       Order saved = orderRepository.save(order);
       return saved;
    }

    public Order get(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        return order;
    }

    public Order delete(Long orderId) {
        Order order= orderRepository.findById(orderId).orElse(null);
        orderRepository.delete(order);
        return order;
    }

//    public Order patch(Long orderId, Order newoder) {
//       Order order = orderRepository.findById(orderId).orElse(null);
//       order.patch(newoder);
//       return order;
//    }
}
