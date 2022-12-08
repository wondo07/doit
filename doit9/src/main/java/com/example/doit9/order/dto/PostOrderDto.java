package com.example.doit9.order.dto;

import com.example.doit9.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderDto {

    private Long orderId;
    private Long memberId;
    private List<PostOrderCoffeeDto> postOrderCoffeeDto;

    public Member getMember(){
        Member member = new Member();
        member.setMemberId(member.getMemberId());
        return member;
    }
}
