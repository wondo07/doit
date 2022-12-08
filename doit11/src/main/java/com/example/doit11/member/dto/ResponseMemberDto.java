package com.example.doit11.member.dto;

import com.example.doit11.member.entity.Member;
import com.example.doit11.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseMemberDto {
    private Long memberId;

    private String email;

    private String name;

    private String phone;

    private Member.MemberStatus memberStatus;

}
