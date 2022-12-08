package com.example.doit5.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatchMemberdto {
    private Long memberId;
    private String email;
    private String name;
    private String phone;
}
