package com.example.doit10.order.dto;


import com.example.doit10.member.entity.Member;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostOrder {
    private Long memberId;
    private List<PostOrderCoffee> postOrderCoffees;

    public Member getMember(){
        Member member = new Member();
        member.setMemberId(memberId);
        return member;
    }
}
