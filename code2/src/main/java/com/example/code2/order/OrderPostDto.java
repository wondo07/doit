package com.example.code2.order;

import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
public class OrderPostDto {

    @Positive
    private long memberId;

    // (1) 여러 잔의 커피를 주문할 수 있도록 수정
    @Valid
    private List<OrderCoffeeDto> orderCoffees;
}
