package com.example.doit11.order.mapper;

import com.example.doit11.coffee.entity.Coffee;
import com.example.doit11.member.entity.Member;
import com.example.doit11.order.dto.PatchOrder;
import com.example.doit11.order.dto.PostOrder;
import com.example.doit11.order.dto.ResponseOrder;
import com.example.doit11.order.dto.ResponseOrderCoffee;
import com.example.doit11.order.entity.Order;
import com.example.doit11.order.entity.OrderCoffee;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    default Order DtotoEntity(PostOrder postOrder){
        Order order = new Order();
        Member member = new Member();
        member.setMemberId(postOrder.getMemberId());
        List<OrderCoffee> orderCoffees = postOrder.getOrderCoffees().stream()
                .map(postOrderCoffee -> {
                    OrderCoffee orderCoffee = new OrderCoffee();
                    orderCoffee.addOrder(order);
                    Coffee coffee = new Coffee();
                    coffee.setCoffeeId(postOrderCoffee.getCoffeeId());
                    orderCoffee.addCoffee(coffee);
                    return orderCoffee;
                    }).collect(Collectors.toList());
        order.setOrderCoffees(orderCoffees);
        order.setMember(member);
        return order;
    }

//    default ResponseOrder EntitytoDto(Order order){
//        ResponseOrder reponseOrder = new ResponseOrder();
//        reponseOrder.setOrderId(order.getOrderId());
//        reponseOrder.setMember(order.getMember());
//        reponseOrder.setOrderStatus(order.getOrderStatus());
//        List<OrderCoffee> orderCoffees= order.getOrderCoffees();
//        reponseOrder.setResponseOrderCoffeeList(ordercoffeetoreponseDto(orderCoffees));
//        return reponseOrder;
//    }
//
//    default List<ResponseOrderCoffee> ordercoffeetoreponseDto(List<OrderCoffee> orderCoffees){
//        return orderCoffees
//                .stream()
//                .map(orderCoffee -> ResponseOrderCoffee
//                        .builder()
//                        .quantity(orderCoffee.getCoffee().getQuantity())
//                        .engname(orderCoffee.getCoffee().getEngname())
//                        .korname(orderCoffee.getCoffee().getKorname())
//                        .coffeeId(orderCoffee.getCoffee().getCoffeeId()).build())
//                .collect(Collectors.toList());
//    }


    default ResponseOrder EntitytoDto(Order order){
        ResponseOrder responseOrder = new ResponseOrder();
        responseOrder.setOrderId(order.getOrderId());
        responseOrder.setOrderStatus(order.getOrderStatus());
        responseOrder.setMember(order.getMember());
        List<ResponseOrderCoffee> responseOrderCoffeeList = order.getOrderCoffees().stream()
                .map(orderCoffee -> ResponseOrderCoffee.builder()
                        .engname(orderCoffee.getCoffee().getEngname())
                        .quantity(orderCoffee.getCoffee().getQuantity())
                        .coffeeId(orderCoffee.getCoffee().getCoffeeId())
                        .korname(orderCoffee.getCoffee().getKorname())
                        .price(orderCoffee.getCoffee().getPrice()).build())
                .collect(Collectors.toList());
        responseOrder.setResponseOrderCoffeeList(responseOrderCoffeeList);

        return responseOrder;
    };

    Order patchDtotoEntity(PatchOrder patchOrder);




}
