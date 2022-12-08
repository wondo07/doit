package com.example.doit10.order.dto;

import com.example.doit10.member.entity.Member;
import com.example.doit10.order.entity.Order;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ReponseOrder {
    private long orderId;
    @Setter(AccessLevel.NONE)
    private long memberId;
    private List<ReponseOrderCoffee> reponseOrderCoffees;
    public void setMember(Member member) {
        this.memberId = member.getMemberId();
    }

    private Order.OrderStatus orderStatus;


}
