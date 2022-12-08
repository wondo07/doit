package com.example.core1.order;

import com.example.core1.discount.fixdiscount;
import com.example.core1.discount.fixdiscountimpl;
import com.example.core1.member.Member;
import com.example.core1.member.MemberRepository;
import com.example.core1.member.MomoryMemberRepository;

public class OrderServiceimpl implements OrderService{

    private final MemberRepository memberRepository=new MomoryMemberRepository();
    private final fixdiscount Discount=new fixdiscountimpl();

    @Override
    public Order createOrder(Long memberid, String itemname, int itemprice) {
        Member member = memberRepository.findbyId(memberid);
        int discount = Discount.discount(member);
        return new Order(memberid,itemname,itemprice,discount);
    }
}
