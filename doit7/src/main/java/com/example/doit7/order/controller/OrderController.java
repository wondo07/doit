package com.example.doit7.order.controller;

import com.example.doit7.dto.SingleResponseDto;
import com.example.doit7.member.dto.PatchMemberdto;
import com.example.doit7.order.dto.PatchOrderDto;
import com.example.doit7.order.dto.PostOrderDto;
import com.example.doit7.order.entity.Order;
import com.example.doit7.order.mapper.OrderMapper;
import com.example.doit7.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;


    @PostMapping
    public ResponseEntity post(@RequestBody PostOrderDto postOrderDto){
        Order order = orderMapper.PostEntity(postOrderDto);
        Order saved= orderService.post(order);
        return new ResponseEntity<>(
                new SingleResponseDto<>(orderMapper.EntitytoDto(saved)),
                HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity get(@PathVariable Long orderId){
        Order order = orderService.get(orderId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(orderMapper.EntitytoDto(order)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity delete(@PathVariable Long orderId){
        Order order = orderService.delete(orderId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(orderMapper.EntitytoDto(order)),
                HttpStatus.OK);
    }

//    @PatchMapping("/{orderId}")
//    public ResponseEntity patch(@PathVariable Long orderId, @RequestBody PatchOrderDto patchOrderDto){
//        Order newoder=orderMapper.PatchEntity(patchOrderDto);
//        Order order = orderService.patch(orderId,newoder);
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(orderMapper.EntitytoDto(order)),
//                HttpStatus.OK);
//

//    }
}
