package com.example.core3;

import com.example.core3.discount.Discount;
import com.example.core3.discount.Fixdiscount;
import com.example.core3.discount.Ratediscount;
import com.example.core3.member.MemberService;
import com.example.core3.member.MemberServiceimpl;
import com.example.core3.member.MemoryMemberRepository;
import com.example.core3.order.OrderService;
import com.example.core3.order.OrderServiceimpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceimpl(MemoryMemberRepositry());
    }

    public OrderService orderService(){
        return new OrderServiceimpl(MemoryMemberRepositry(), discountPolicy());
    }


    public Discount discountPolicy() {
        return new Ratediscount();
    }

    public MemoryMemberRepository MemoryMemberRepositry() {
        return new MemoryMemberRepository();
    }




}
