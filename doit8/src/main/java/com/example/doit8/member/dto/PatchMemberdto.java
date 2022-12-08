package com.example.doit8.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PatchMemberdto {
    private Long memberId;
    private String email;
    private String name;
    private String phone;
}
