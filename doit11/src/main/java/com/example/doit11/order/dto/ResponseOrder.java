package com.example.doit11.order.dto;

import com.example.doit11.member.entity.Member;
import com.example.doit11.order.entity.Order;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ResponseOrder {
    @Setter(AccessLevel.NONE)
    private Long memberId;
    private Long orderId;
    private List<ResponseOrderCoffee> responseOrderCoffeeList;
    private Order.OrderStatus orderStatus;


    public void setMember(Member member) {
        this.memberId = member.getMemberId();
    }


}
