package com.example.doit7.ordercoffee.controller;

import com.example.doit7.dto.SingleResponseDto;
import com.example.doit7.order.dto.PostOrderCoffee;
import com.example.doit7.order.entity.OrderCoffee;
import com.example.doit7.ordercoffee.mapper.OrderCoffeeMapper;
import com.example.doit7.ordercoffee.service.OrderCoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordercoffee")
public class OrderCoffeeController {

    @Autowired
    private OrderCoffeeMapper orderCoffeeMapper;
    @Autowired
    private OrderCoffeeService orderCoffeeService;

    @PostMapping
    public ResponseEntity post(@RequestBody PostOrderCoffee postOrderCoffee){
       OrderCoffee orderCoffee = orderCoffeeMapper.input(postOrderCoffee);
       OrderCoffee orderCoffee1 = orderCoffeeService.save(orderCoffee);
       return new ResponseEntity<>(
                new SingleResponseDto<>(orderCoffeeMapper.toreponse(orderCoffee1)),
                HttpStatus.CREATED);
    }

    @GetMapping("/{ordercoffeeId}")
    public ResponseEntity get(@PathVariable Long ordercoffeeId){
       OrderCoffee orderCoffee  = orderCoffeeService.get(ordercoffeeId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(orderCoffeeMapper.toreponse(orderCoffee)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{orderCoffeeId}")
    public ResponseEntity delete(@PathVariable Long orderCoffeeId){
       OrderCoffee orderCoffee = orderCoffeeService.delete(orderCoffeeId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(orderCoffeeMapper.toreponse(orderCoffee)),
                HttpStatus.OK);
    }

}
