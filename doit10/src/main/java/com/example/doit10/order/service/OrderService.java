package com.example.doit10.order.service;

import com.example.doit10.order.entity.Order;
import com.example.doit10.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saved(Order order) {
        Order saved = orderRepository.save(order);
        return saved;
    }

    public Order patch(Order order, Long orderId) {
        Order oldorder = orderRepository.findById(orderId).orElse(null);
        oldorder.patch(order);
        Order saved = orderRepository.save(oldorder);
        return saved;
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

    public Page<Order> findOrders(int page, int size){
        PageRequest pageRequest= PageRequest.of(page,size);
        return orderRepository.findAll(pageRequest);
    }
    public List<Order> findOrders(){
        return (List<Order>) orderRepository.findAll(Sort.by(Sort.Direction.ASC,"orderId"));
    }

}
