package com.example.doit6.OrderCoffee.service;

import com.example.doit6.OrderCoffee.entity.OrderCoffee;
import com.example.doit6.OrderCoffee.repository.OrderCoffeeRepository;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCoffeeService {

    @Autowired
    private OrderCoffeeRepository orderCoffeeRepository;

    public OrderCoffee create(OrderCoffee ordercoffee) {
        OrderCoffee orderCoffee = orderCoffeeRepository.save(ordercoffee);
        return orderCoffee;
    }
}
