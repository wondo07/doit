package com.example.doit11.order.dto;


import com.example.doit11.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostOrder {

    private Long memberId;
    private List<PostOrderCoffee> orderCoffees;

    public Member getMember(){
        Member member = new Member();
        member.setMemberId(memberId);
        return member;
    }
}
