package com.example.doit8.member.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class MemberResponse {
    private long memberId;
    private String email;
    private String name;
    private String phone;
}
