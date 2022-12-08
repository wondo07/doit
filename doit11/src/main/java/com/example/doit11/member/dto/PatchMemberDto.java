package com.example.doit11.member.dto;


import com.example.doit11.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatchMemberDto {
    private String email;
    private String name;
    private String phone;
    private Member.MemberStatus memberStatus;
}
