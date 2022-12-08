package com.example.core3.member;

import com.example.core3.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceimplTest {

    MemberService memberService;
    @BeforeEach
    public void beforeeach(){
        AppConfig appConfig=new AppConfig();
        memberService=appConfig.memberService();
    }

    @Test
    void join(){
        // given
        Member member=new Member(1L,"membera",Grade.VIP);

        // when
        memberService.join(member);
        Member findmember=memberService.findbyId(1L);
        // then
        Assertions.assertThat(findmember.getName()).isEqualTo(member.getName());
    }

}