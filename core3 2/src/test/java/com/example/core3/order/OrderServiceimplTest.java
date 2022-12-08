package com.example.core3.order;

import com.example.core3.AppConfig;
import com.example.core3.discount.Discount;
import com.example.core3.member.Grade;
import com.example.core3.member.Member;
import com.example.core3.member.MemberService;
import com.example.core3.member.MemberServiceimpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceimplTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeeach(){
        AppConfig appConfig=new AppConfig();
        memberService = appConfig.memberService();
        orderService= appConfig.orderService();
    }

    @Test
    void join() {
        Member member = new Member(1L, "membera", Grade.VIP);
        memberService.join(member);
        Order order=orderService.creator(1L,"item1",10000);
        Assertions.assertThat(order.getDiscunt()).isEqualTo(1000);
    }
}