package com.example.core3.order;

public interface OrderService {

    Order creator(Long memberId,String itemname,int itemprice);
}
