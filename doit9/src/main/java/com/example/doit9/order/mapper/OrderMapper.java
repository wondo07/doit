package com.example.doit9.order.mapper;

import com.example.doit9.coffee.entity.Coffee;
import com.example.doit9.member.entity.Member;
import com.example.doit9.order.dto.OrderCoffeeReponse;
import com.example.doit9.order.dto.OrderResponse;
import com.example.doit9.order.dto.PostOrderDto;
import com.example.doit9.order.entity.Order;
import com.example.doit9.order.entity.OrderCoffee;
import org.aspectj.weaver.ast.Or;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    default Order entityDto(PostOrderDto postOrderDto){
        Order order=new Order();
        Member member=new Member();
        member.setMemberId(postOrderDto.getMemberId());
        order.setMember(member);

        List<OrderCoffee> orderCoffeeList=postOrderDto.getPostOrderCoffeeDto().stream()
                .map(postOrderCoffeeDto -> {
                    OrderCoffee orderCoffee=new OrderCoffee();
                    Coffee coffee =new Coffee();
                    orderCoffee.addOrder(order);
                    orderCoffee.addCoffee(coffee);
                    orderCoffee.setQuantity(postOrderCoffeeDto.getQuantity());
                    orderCoffee.setCoffee(coffee);
                    orderCoffee.setOrdercoffeeId(postOrderCoffeeDto.getOrdercoffeeId());
                    return orderCoffee;
                }).collect(Collectors.toList());
        order.setOrderCoffeeList(orderCoffeeList);
        return order;
    }

    default OrderResponse DtotoEntity(Order order){

        List<OrderCoffee> orderCoffeeList = order.getOrderCoffeeList();
        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setMemberId(order.getMember().getMemberId());
        orderResponse.setOrderCoffeeReponses(OrderMapper.dtoResponse(orderCoffeeList));
        return orderResponse;
    }

    static List<OrderCoffeeReponse> dtoResponse(List<OrderCoffee> orderCoffeeList) {
        return orderCoffeeList.stream()
                .map(orderCoffee -> OrderCoffeeReponse.builder()
                        .coffeeId(orderCoffee.getCoffee().getCoffeeId())
                        .korName(orderCoffee.getCoffee().getKorname())
                        .engName(orderCoffee.getCoffee().getEngname())
                        .price(orderCoffee.getCoffee().getPrice())
                        .build())
                .collect(Collectors.toList());
    }


}
