package com.example.core1.discount;

import com.example.core1.member.Grade;
import com.example.core1.member.Member;

public class fixdiscountimpl implements fixdiscount {


    @Override
    public int discount(Member member) {
        if(member.getGrade()== Grade.VIP){
            return 1000;
        }
        else {
            return 0;
        }
    }
}
