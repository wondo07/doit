package com.example.core1.order;

public interface OrderService {
    Order createOrder(Long memberid, String itemname, int itemprice);

}
