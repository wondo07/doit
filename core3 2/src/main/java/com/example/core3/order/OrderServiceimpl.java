package com.example.core3.order;

import com.example.core3.discount.Discount;
import com.example.core3.discount.Fixdiscount;
import com.example.core3.member.Member;
import com.example.core3.member.MemberRepository;

public class OrderServiceimpl implements OrderService{

    private final MemberRepository memberRepository;
    private final Discount pricediscount;

    public OrderServiceimpl(MemberRepository memberRepository, Discount pricediscount) {
        this.memberRepository = memberRepository;
        this.pricediscount = pricediscount;
    }

    @Override
    public Order creator(Long id, String itemname, int itemprice) {
        Member member =memberRepository.findbyId(id);
        int discount= pricediscount.discount(member,itemprice);
        return new Order(id,itemname,itemprice,discount);
    }
}
