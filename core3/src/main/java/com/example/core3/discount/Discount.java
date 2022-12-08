package com.example.core3.discount;

import com.example.core3.member.Member;

public interface Discount {
    int discount(Member member, int price);
}
