package com.example.core3.order;

public class Order {
    private Long id;
    private String itemname;
    private int itemprice;
    private int discunt;

    public Order(Long id, String itemname, int itemprice, int discunt) {
        this.id = id;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.discunt = discunt;
    }

    public int calculator(){
        return itemprice-discunt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getDiscunt() {
        return discunt;
    }

    public void setDiscunt(int discunt) {
        this.discunt = discunt;
    }
}
