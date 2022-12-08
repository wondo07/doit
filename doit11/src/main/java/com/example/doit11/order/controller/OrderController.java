package com.example.doit11.order.controller;

import com.example.doit11.dto.SingleDto;
import com.example.doit11.order.dto.PatchOrder;
import com.example.doit11.order.dto.PostOrder;
import com.example.doit11.order.entity.Order;
import com.example.doit11.order.mapper.OrderMapper;
import com.example.doit11.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity post(@RequestBody PostOrder postOrder){
        Order order = orderMapper.DtotoEntity(postOrder);
        Order saved = orderService.saved(order);
        return new ResponseEntity<>(
                new SingleDto<>(orderMapper.EntitytoDto(saved)), HttpStatus.CREATED);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity delete(@RequestBody PatchOrder patchOrder,
                                 @PathVariable Long orderId){
        Order order = orderMapper.patchDtotoEntity(patchOrder);
        Order saved = orderService.patch(orderId,order);
        return new ResponseEntity<>(
                new SingleDto<>(orderMapper.EntitytoDto(saved)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity delete(@PathVariable Long orderId){
        Order order = orderService.delete(orderId);
        return new ResponseEntity<>(
                new SingleDto<>(orderMapper.EntitytoDto(order)), HttpStatus.OK
        );
    }

    @GetMapping("/{orderId}")
    public ResponseEntity get(@PathVariable Long orderId){
        Order order = orderService.get(orderId);
        return new ResponseEntity<>(
                new SingleDto<>(orderMapper.EntitytoDto(order)), HttpStatus.OK
        );
    }


}
