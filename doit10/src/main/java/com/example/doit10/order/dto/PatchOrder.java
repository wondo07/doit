package com.example.doit10.order.dto;

import com.example.doit10.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchOrder {
    private Long orderId;
    private Long memberId;

    private Order.OrderStatus orderStatus;
}
