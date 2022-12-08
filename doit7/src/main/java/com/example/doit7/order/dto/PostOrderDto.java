package com.example.doit7.order.dto;


import com.example.doit7.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostOrderDto {

    private Long memberId;
    private List<PostOrderCoffee> postOrderCoffees;

    public Member getMember(){
        Member member = new Member();
        member.setMemberId(memberId);
        return member;
    }
}
