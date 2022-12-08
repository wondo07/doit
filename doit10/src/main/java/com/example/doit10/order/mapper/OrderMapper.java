package com.example.doit10.order.mapper;

import com.example.doit10.coffee.entity.Coffee;
import com.example.doit10.member.entity.Member;
import com.example.doit10.order.dto.PatchOrder;
import com.example.doit10.order.dto.PostOrder;
import com.example.doit10.order.dto.ReponseOrder;
import com.example.doit10.order.dto.ReponseOrderCoffee;
import com.example.doit10.order.entity.Order;
import com.example.doit10.order.entity.OrderCoffee;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    Order PatchtoEntity(PatchOrder patchOrder);

    List<ReponseOrder> ordersToResponse(List<Order> orders);

    default Order PosttoEntity(PostOrder postOrder){
        Order order = new Order();
        Member member = new Member();
        member.setMemberId(postOrder.getMemberId());
        List<OrderCoffee> orderCoffees = postOrder.getPostOrderCoffees().stream()
                .map(postOrderCoffee -> {
                    OrderCoffee orderCoffee = new OrderCoffee();
                    Coffee coffee = new Coffee();
                    coffee.setCoffeeId(postOrderCoffee.getCoffeeId());
                    orderCoffee.addCoffee(coffee);
                    orderCoffee.addOrder(order);
                    return orderCoffee;
                }).collect(Collectors.toList());
        order.setOrderCoffees(orderCoffees);
        order.setMember(member);
        return order;
    }


    default ReponseOrder reponse(Order order){
        ReponseOrder reponseOrder = new ReponseOrder();
        reponseOrder.setOrderId(order.getOrderId());
        reponseOrder.setMember(order.getMember());
        reponseOrder.setOrderStatus(order.getOrderStatus());
        List<OrderCoffee> orderCoffees= order.getOrderCoffees();
        reponseOrder.setReponseOrderCoffees(ordercoffeetoreponseDto(orderCoffees));
        return reponseOrder;
    }

    default List<ReponseOrderCoffee> ordercoffeetoreponseDto(List<OrderCoffee> orderCoffees){
        return orderCoffees
                .stream()
                .map(orderCoffee -> ReponseOrderCoffee
                        .builder()
                        .quantity(orderCoffee.getCoffee().getQuantity())
                        .engname(orderCoffee.getCoffee().getEngname())
                        .korname(orderCoffee.getCoffee().getKorname())
                        .coffeeId(orderCoffee.getCoffee().getCoffeeId()).build())
                .collect(Collectors.toList());
    }
}
