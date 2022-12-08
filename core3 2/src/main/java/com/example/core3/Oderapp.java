package com.example.core3;

import com.example.core3.member.Grade;
import com.example.core3.member.Member;
import com.example.core3.member.MemberService;
import com.example.core3.order.Order;
import com.example.core3.order.OrderService;

public class Oderapp {
    public static void main(String[] args) {
        MemberService memberService;
        OrderService orderService;
        AppConfig appConfig=new AppConfig();
        memberService = appConfig.memberService();
        orderService= appConfig.orderService();

        Member member = new Member(1L, "membera", Grade.VIP);
        memberService.join(member);
        Order order=orderService.creator(1L,"item1",10000);
        System.out.println(order.getDiscunt());
    }
}
