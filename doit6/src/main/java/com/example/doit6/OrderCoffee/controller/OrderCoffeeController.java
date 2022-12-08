package com.example.doit6.OrderCoffee.controller;

import com.example.doit6.OrderCoffee.dto.OrderCoffeeResponseDto;
import com.example.doit6.OrderCoffee.dto.PostOrderCoffeeDto;
import com.example.doit6.OrderCoffee.entity.OrderCoffee;
import com.example.doit6.OrderCoffee.mapper.OrderCoffeeMapper;
import com.example.doit6.OrderCoffee.service.OrderCoffeeService;
import com.example.doit6.dto.SingleResponseDto;
import com.example.doit6.order.dto.PostOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordercoffee")
public class OrderCoffeeController {

    @Autowired
    private OrderCoffeeService orderCoffeeService;
    @Autowired
    private OrderCoffeeMapper orderCoffeeMapper;

    @PostMapping
    public ResponseEntity post(@RequestBody PostOrderCoffeeDto postOrderCoffeeDto){
        OrderCoffee orderCoffee=orderCoffeeService.create(orderCoffeeMapper.toentity(postOrderCoffeeDto));
        OrderCoffeeResponseDto orderCoffeeResponseDto=orderCoffeeMapper.entitytodto(orderCoffee);
        return (orderCoffeeResponseDto != null)?
                ResponseEntity.status(HttpStatus.OK).body(orderCoffeeResponseDto):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
