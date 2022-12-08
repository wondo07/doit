package com.example.doit10.member.dto;

import com.example.doit10.member.entity.Member;
import com.example.doit10.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ReponseDto {
    private Long memberId;
    private String email;
    private String phone;
    private String name;
    private List<Order> orderList;
    private Member.MemberStatus memberStatus;
    public String getMemberStatus() {
        return memberStatus.getStatus();
    }

}


