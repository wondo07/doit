package com.example.doit5.order.dto;

import com.example.doit5.order.entity.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class Orderdto {

    private Long orderId;
    @JsonProperty("memberId")
    private Long memberId;


    public static Orderdto createddto(Order a) {
        return new Orderdto(
                a.getOrderId(),
                a.getMember().getMemberId()
        );

    }
}
