package com.example.core3;

import com.example.core3.member.*;
import com.example.core3.order.Order;
import com.example.core3.order.OrderService;
import com.example.core3.order.OrderServiceimpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig=new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService=new MemberServiceimpl();
        OrderService orderService=appConfig.orderService();
//        OrderService orderService=new OrderServiceimpl();

        Long memberId=1L;

        Member member=new Member(memberId,"membera", Grade.VIP);
        memberService.join(member);

        Order order=orderService.creator(memberId, "itemA", 10000);
        System.out.println("order = " + order.calculator());
        System.out.println("order = " + order.getDiscount());
//        System.out.println("discount = "+ order.calculator());
    }
}
