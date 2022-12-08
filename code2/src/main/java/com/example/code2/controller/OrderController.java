package com.example.code2.controller;

import com.example.code2.order.Order;
import com.example.code2.order.OrderMapper;
import com.example.code2.order.OrderPostDto;
import com.example.code2.order.OrderResponseDto;
import com.example.code2.service.CoffeeService;
import com.example.code2.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v10/orders")
@Validated
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper mapper;
    private final CoffeeService coffeeService;
    public OrderController(OrderService orderService,
                           OrderMapper mapper,
                           CoffeeService coffeeService) {
        this.orderService = orderService;
        this.mapper = mapper;
        this.coffeeService = coffeeService;
    }

    @PostMapping
    public ResponseEntity postOrder(@Valid @RequestBody OrderPostDto orderPostDto) {
        Order order =
                orderService.createOrder(mapper.orderPostDtoToOrder(orderPostDto));

        // (1) 주문한 커피 정보를 가져오도록 수정
        return new ResponseEntity<>(mapper.orderToOrderResponseDto(coffeeService, order), HttpStatus.CREATED);
    }

    @PostMapping


    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId){
        Order order = orderService.findOrder(orderId);

        // (2) 주문한 커피 정보를 가져오도록 수정
        return new ResponseEntity<>(mapper.orderToOrderResponseDto(coffeeService, order), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders() {
        List<Order> orders = orderService.findOrders();

        // (3) 주문한 커피 정보를 가져오도록 수정
        List<OrderResponseDto> response =
                orders.stream().map(order -> mapper.orderToOrderResponseDto(coffeeService, order)).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity cancelOrder(@PathVariable("order-id") @Positive long orderId){
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
