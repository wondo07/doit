package com.example.doit6.order.service;

import com.example.doit6.member.repository.MemberRepository;
import com.example.doit6.order.dto.OrderReponseDto;
import com.example.doit6.order.dto.PostOrderDto;
import com.example.doit6.order.entity.Order;
import com.example.doit6.order.mapper.OrderMapper;
import com.example.doit6.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private  OrderMapper orderMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MemberRepository memberRepository;



    public OrderReponseDto input(PostOrderDto postOrderdto) {
        Order order = orderMapper.orderdtotoentity(postOrderdto);
        orderRepository.save(order);
        OrderReponseDto reponsedto = orderMapper.createddto(order);
        return reponsedto;
    }

    public List<OrderReponseDto> get(Long membersid) {
        List<Order> order = orderRepository.findByAriticleId(membersid);

        List<OrderReponseDto> dtos=order.stream()
                .map(a->orderMapper.createddto(a))
                .collect(Collectors.toList());
        return dtos;
    }

    public Optional<Order> show(Long orderId) {
       Optional<Order> order  = orderRepository.findById(orderId);
       return order;
    }
}
