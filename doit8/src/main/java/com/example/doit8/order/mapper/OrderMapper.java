package com.example.doit8.order.mapper;

import com.example.doit8.coffee.entity.Coffee;
import com.example.doit8.member.entity.Member;
import com.example.doit8.order.dto.OrderCoffeeResponse;
import com.example.doit8.order.dto.OrderResponse;
import com.example.doit8.order.dto.PostOrderDto;
import com.example.doit8.order.entity.Order;
import com.example.doit8.order.entity.OrderCoffee;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    default Order DtotoEntity(PostOrderDto postOrderDto){
        Order order = new Order();
        Member member = new Member();
        member.setMemberId(postOrderDto.getMemberId());
        List<OrderCoffee> orderCoffeeList = postOrderDto.getOrdercoffee().stream()
                .map(orderCoffeeDto -> {
                    OrderCoffee orderCoffee = new OrderCoffee();
                    Coffee coffee=new Coffee();
                    coffee.setCoffeeId(orderCoffeeDto.getCoffeeId());
                    orderCoffee.addOrder(order);
                    orderCoffee.addCoffee(coffee);
                    orderCoffee.setQuantity(orderCoffeeDto.getQuantity());
                    return orderCoffee;
                }).collect(Collectors.toList());
        order.setMember(member);
        order.setOrderId(postOrderDto.getOrderId());
        order.setOrderCoffeeList(orderCoffeeList);
        return order;
    }

    default OrderResponse orderToOrderResponseDto(Order order){
        List<OrderCoffee> ordercoffee=order.getOrderCoffeeList();
        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setMember(order.getMember());
        orderResponse.setOrderCoffeeResponseList(orderCoffeesToOrderCoffeeResponseDtos(ordercoffee));
        return orderResponse;
    }

    default List<OrderCoffeeResponse> orderCoffeesToOrderCoffeeResponseDtos(List<OrderCoffee> ordercoffee){
        return ordercoffee
                .stream()
                .map(orderCoffees -> OrderCoffeeResponse.builder()
                        .coffeeId(orderCoffees.getCoffee().getCoffeeId())
                        .engName(orderCoffees.getCoffee().getEngname())
                        .korName(orderCoffees.getCoffee().getKorname())
                        .price(orderCoffees.getCoffee().getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
