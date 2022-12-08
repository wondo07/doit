package com.example.core3.discount;

import com.example.core3.member.Grade;
import com.example.core3.member.Member;



public class Fixdiscount implements Discount {

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return 1000;
        }
        else {
            return 0;
        }
    }
}
