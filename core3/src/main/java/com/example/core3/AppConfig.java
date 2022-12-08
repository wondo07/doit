package com.example.core3;

import com.example.core3.discount.Discount;
import com.example.core3.discount.Fixdiscount;
import com.example.core3.member.MemberRepository;
import com.example.core3.member.MemberService;
import com.example.core3.member.MemberServiceimpl;
import com.example.core3.member.MemoryMemberRepository;
import com.example.core3.order.Order;
import com.example.core3.order.OrderService;
import com.example.core3.order.OrderServiceimpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceimpl(MemberRepository());
    }

    private MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }


    public OrderService orderService(){
        return new OrderServiceimpl(new MemoryMemberRepository(),new Fixdiscount());
    }
    public Discount discountPolicy() {
//        return new FixDiscountPolicy();
        return new Fixdiscount();
    }
}
