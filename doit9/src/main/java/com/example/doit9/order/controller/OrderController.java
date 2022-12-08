package com.example.doit9.order.controller;

import com.example.doit9.dto.singlereponsedto;
import com.example.doit9.order.dto.PostOrderDto;
import com.example.doit9.order.entity.Order;
import com.example.doit9.order.mapper.OrderMapper;
import com.example.doit9.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;

    public ResponseEntity post(@RequestBody PostOrderDto postOrderDto){
        Order order = orderMapper.entityDto(postOrderDto);
        Order saved = orderService.save(order);
        return new ResponseEntity<>(
                new singlereponsedto<>(orderMapper.DtotoEntity(saved)),HttpStatus.CREATED);

    }

}
