package com.example.doit10.member.dto;


import com.example.doit10.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatchMemberDto {

    private String email;
    private String phone;
    private String name;
    private Member.MemberStatus memberStatus;
}
