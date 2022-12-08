package com.example.doit5.order.controller;

import com.example.doit5.member.dto.PostMemberdto;
import com.example.doit5.order.OrderMapper.OrderMapper;
import com.example.doit5.order.dto.OrderReponsedto;
import com.example.doit5.order.dto.Orderdto;
import com.example.doit5.order.dto.PostOrderdto;
import com.example.doit5.order.dto.SingleResponseDto;
import com.example.doit5.order.entity.Order;
import com.example.doit5.order.repository.OrderRepository;
import com.example.doit5.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody PostOrderdto postOrderdto){
        OrderReponsedto reponsedto = orderService.input(postOrderdto);

        return (reponsedto != null)?
                ResponseEntity.status(HttpStatus.OK).body(reponsedto):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/{member_id}")
    public ResponseEntity<List<OrderReponsedto>> get(@PathVariable("member_id") Long membersid){
        List<OrderReponsedto> dtos = orderService.get(membersid);
        return (dtos != null)?
                ResponseEntity.status(HttpStatus.OK).body(dtos):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
