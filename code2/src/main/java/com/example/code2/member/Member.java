package com.example.code2.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
public class Member {

    @Id
    private Long memberId;
    private String email;
    private String name;
    private String phone;

}
