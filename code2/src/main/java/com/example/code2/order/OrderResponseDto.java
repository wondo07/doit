package com.example.code2.order;

import com.example.code2.coffee.OrderCoffeeResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private long orderId;
    private long memberId;
    private Order.OrderStatus orderStatus;
    private List<OrderCoffeeResponseDto> orderCoffees;
    private LocalDateTime createdAt;
}
