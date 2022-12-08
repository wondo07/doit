package com.example.doit5.order.entity;

import com.example.doit5.member.entity.Member;
import com.example.doit5.order.dto.OrderCoffeedto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name = "member_id")
    private Member member;
//    private List<OrderCoffeedto> orderCoffees;


}
