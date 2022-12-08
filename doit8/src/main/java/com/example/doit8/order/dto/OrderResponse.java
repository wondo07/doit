package com.example.doit8.order.dto;

import com.example.doit8.member.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class OrderResponse {
    private long orderId;
    @Setter(AccessLevel.NONE)
    private long memberId;
    private List<OrderCoffeeResponse> orderCoffeeResponseList;

    public void setMember(Member member) {
        this.memberId = member.getMemberId();
    }
}
