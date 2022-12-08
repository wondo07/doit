package com.example.doit6.order.dto;


import com.example.doit6.member.entity.Member;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
public class PostOrderDto {

    @Positive
    private Long orderId;
    @Positive
    private long memberId;

//    @Valid
//    private List<OrderCoffeeDto> orderCoffees;

    public Member getMember() {
        Member member = new Member();
        member.setMemberId(memberId);
        return member;
    }
}
