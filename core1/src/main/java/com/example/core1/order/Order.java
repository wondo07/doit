package com.example.core1.order;

public class Order {

    private Long memberId;
    private String itemname;
    private int itemprice;
    private int discount;

    public int calculator(){
        return itemprice-discount;
    }

    public Order(Long memberId, String itemname, int itemprice, int discount) {
        this.memberId = memberId;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.discount = discount;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getItemprice() {
        return itemprice;
    }

    public void setItemprice(int itemprice) {
        this.itemprice = itemprice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemname='" + itemname + '\'' +
                ", itemprice=" + itemprice +
                ", discount=" + discount +
                '}';
    }
}
