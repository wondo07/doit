package com.example.core3.order;

import com.example.core3.discount.Discount;
import com.example.core3.discount.Fixdiscount;
import com.example.core3.member.*;

public class OrderServiceimpl implements OrderService{

    private final MemberRepository memberRepository;
    private final Discount discount;

    public OrderServiceimpl(MemberRepository memberRepository, Discount discount) {
        this.memberRepository = memberRepository;
        this.discount = discount;
    }

    @Override
    public Order creator(Long memberId, String itemname, int itemprice) {
        Member member = memberRepository.findbyId(memberId);
        int dicountprice = discount.discount(member,itemprice);
        return new Order(memberId,itemname,itemprice,dicountprice);

    }
}
