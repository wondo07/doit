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
public class PostMemberDto {
    private String email;
    private String name;
    private String phone;



}
