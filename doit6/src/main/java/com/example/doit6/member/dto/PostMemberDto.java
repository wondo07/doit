package com.example.doit6.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostMemberDto {

    private Long memberId;
    private String email;
    private String name;
    private String phone;
}
