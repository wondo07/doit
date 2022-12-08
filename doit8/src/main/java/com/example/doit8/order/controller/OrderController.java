package com.example.doit8.order.controller;


import com.example.doit8.dto.SingleResponseDto;
import com.example.doit8.order.dto.PostOrderDto;
import com.example.doit8.order.entity.Order;
import com.example.doit8.order.mapper.OrderMapper;
import com.example.doit8.order.repository.OrderRepository;
import com.example.doit8.order.service.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity input(@RequestBody PostOrderDto postOrderDto){
        Order order= orderMapper.DtotoEntity(postOrderDto);
        Order saved=orderService.save(order);

        return new ResponseEntity<>(
                new SingleResponseDto<>(orderMapper.orderToOrderResponseDto(saved)),
                HttpStatus.CREATED);

    }

    @GetMapping("/{orderId}")
    public ResponseEntity get(@PathVariable Long orderId){
        Order order = orderService.get(orderId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(orderMapper.orderToOrderResponseDto(order)),
                HttpStatus.OK);
    }

}
