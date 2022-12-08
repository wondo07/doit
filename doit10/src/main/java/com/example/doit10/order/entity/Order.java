package com.example.doit10.order.entity;

import com.example.doit10.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST)
    List<OrderCoffee> orderCoffees=new ArrayList<>();

    @Column
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.ORDER_REQUEST;

    public void setMember(Member member) {
        this.member = member;
    }
    public void patch(Order order) {
        if(member != order.member){
            this.member=order.member;
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", member=" + member +
                ", orderCoffees=" + orderCoffees +
                ", orderStatus=" + orderStatus +
                '}';
    }

    public enum OrderStatus{
        ORDER_REQUEST("주문 요청중"),
        ORDER_CONFIRM("주문 확인중"),
        ORDER_COMPLETE("주문 완료"),
        ORDER_QUIT("주문 취소");

        @Getter
        private String status;

        OrderStatus(String status) {
            this.status = status;
        }
    }

}
