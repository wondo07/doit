package com.example.doit6.order.controller;

import com.example.doit6.order.dto.OrderReponseDto;
import com.example.doit6.order.dto.PostOrderDto;
import com.example.doit6.order.entity.Order;
import com.example.doit6.order.mapper.OrderMapper;
import com.example.doit6.order.repository.OrderRepository;
import com.example.doit6.order.service.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity post(@RequestBody PostOrderDto postOrderDto){
        OrderReponseDto reponsedto = orderService.input(postOrderDto);

        return (reponsedto != null)?
                ResponseEntity.status(HttpStatus.OK).body(reponsedto):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity get(@RequestBody Long orderId){
        Optional<Order> order = orderService.show(orderId);
        OrderReponseDto orderReponseDto = orderMapper.entitytodto(order);
        return (orderReponseDto != null)?
                ResponseEntity.status(HttpStatus.OK).body(orderReponseDto):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();




    }
}
