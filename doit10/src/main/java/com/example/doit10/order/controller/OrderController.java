package com.example.doit10.order.controller;

import com.example.doit10.dto.AlltoDto;
import com.example.doit10.dto.SingleDto;
import com.example.doit10.member.dto.PageInfo;
import com.example.doit10.order.dto.PatchOrder;
import com.example.doit10.order.dto.PostOrder;
import com.example.doit10.order.dto.ReponseOrder;
import com.example.doit10.order.entity.Order;
import com.example.doit10.order.mapper.OrderMapper;
import com.example.doit10.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PatchExchange;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity post(@RequestBody PostOrder postOrder){
        Order order = orderMapper.PosttoEntity(postOrder);
        System.out.println("order : "+order);
        Order saved = orderService.saved(order);
        System.out.println("order1 : "+order);

        return new ResponseEntity<>(
                new SingleDto<>(orderMapper.reponse(saved)), HttpStatus.CREATED);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity patch(@RequestBody PatchOrder patchOrder,
                                @PathVariable Long orderId){
        Order order = orderMapper.PatchtoEntity(patchOrder);
        Order saved= orderService.patch(order,orderId);
        return new ResponseEntity<>(
                new SingleDto<>(orderMapper.reponse(saved)), HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity delete(@PathVariable Long orderId){
        Order order = orderService.delete(orderId);
        return new ResponseEntity<>(
                new SingleDto<>(orderMapper.reponse(order)), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity get(@PathVariable Long orderId){
        Order order = orderService.get(orderId);
        return new ResponseEntity<>(
                new SingleDto<>(orderMapper.reponse(order)), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getorder(@RequestParam int page,
                                   @RequestParam int size){
        Page<Order> orderPage = orderService.findOrders(page-1,size);
        PageInfo pageInfo= new PageInfo(page,size,(int) orderPage.getTotalElements(),orderPage.getTotalPages());
        List<Order> orders=orderService.findOrders();
        List<ReponseOrder> responseOrder= orderMapper.ordersToResponse(orders);
        return new ResponseEntity<>(new AlltoDto(responseOrder,pageInfo),HttpStatus.OK);
    }

}
