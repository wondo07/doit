package com.example.core1;

import com.example.core1.discount.fixdiscount;
import com.example.core1.discount.fixdiscountimpl;
import com.example.core1.member.*;
import com.example.core1.order.Order;
import com.example.core1.order.OrderService;
import com.example.core1.order.OrderServiceimpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService=new MemberServiceimpl();
        OrderService orderService=new OrderServiceimpl();

        Long memberId=1L;

        Member member=new Member(memberId,"memberd", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("discount = "+ order.calculator());


    }
}
