package com.example.doit8.order.dto;


import com.example.doit8.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostOrderDto {

    private Long orderId;
    private Long memberId;
    private List<PostOrderCoffeeDto> ordercoffee;

    public Member getMember(){
        Member member = new Member();
        member.setMemberId(memberId);
        return member;
    }

}
