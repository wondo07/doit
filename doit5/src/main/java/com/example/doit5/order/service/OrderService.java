package com.example.doit5.order.service;

import com.example.doit5.member.repository.MemberRepository;
import com.example.doit5.order.OrderMapper.OrderMapper;
import com.example.doit5.order.dto.OrderReponsedto;
import com.example.doit5.order.dto.Orderdto;
import com.example.doit5.order.dto.PostOrderdto;
import com.example.doit5.order.entity.Order;
import com.example.doit5.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    private final MemberRepository memberRepository;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository, MemberRepository memberRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.memberRepository = memberRepository;
    }


    public OrderReponsedto input(PostOrderdto postOrderdto) {
        Order order = orderMapper.orderdtotoentity(postOrderdto);
        orderRepository.save(order);
        OrderReponsedto reponsedto = orderMapper.createddto(order);
        return reponsedto;
    }

    public List<OrderReponsedto> get(Long membersid) {
       List<Order> order = orderRepository.findByAriticleId(membersid);

        List<OrderReponsedto> dtos=order.stream()
               .map(a->orderMapper.createddto(a))
               .collect(Collectors.toList());
       return dtos;
    }
}
