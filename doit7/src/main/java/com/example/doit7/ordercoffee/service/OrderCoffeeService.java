package com.example.doit7.ordercoffee.service;


import com.example.doit7.order.entity.OrderCoffee;
import com.example.doit7.ordercoffee.repository.OrderCoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCoffeeService {
    @Autowired
    private OrderCoffeeRepository orderCoffeeRepository;
    public OrderCoffee save(OrderCoffee orderCoffee) {
        OrderCoffee saved = orderCoffeeRepository.save(orderCoffee);
        return saved;
    }

    public OrderCoffee get(Long ordercoffeeId) {
        OrderCoffee orderCoffee = orderCoffeeRepository.findById(ordercoffeeId).orElse(null);
        return orderCoffee;
    }

    public OrderCoffee delete(Long orderCoffeeId) {
        OrderCoffee orderCoffee = orderCoffeeRepository.findById(orderCoffeeId).orElse(null);
        orderCoffeeRepository.delete(orderCoffee);
        return orderCoffee;
    }
}
