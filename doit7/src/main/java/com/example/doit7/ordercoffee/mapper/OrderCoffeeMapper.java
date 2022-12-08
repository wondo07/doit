package com.example.doit7.ordercoffee.mapper;

import com.example.doit7.order.entity.Order;
import com.example.doit7.order.dto.OrderCoffeeReponse;
import com.example.doit7.order.dto.PostOrderCoffee;
import com.example.doit7.order.entity.OrderCoffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderCoffeeMapper {

    OrderCoffee input(PostOrderCoffee postOrderCoffee);

    OrderCoffeeReponse toreponse(OrderCoffee orderCoffee);

    default OrderCoffeeReponse ordertodto(Order order){
        List<OrderCoffee> orderCoffees=order.getOrderCoffees();
        OrderCoffeeReponse orderCoffeeReponse=new OrderCoffeeReponse();
        orderCoffeeReponse.setCoffeeId(order.getOrderId());
        orderCoffeeReponse.setOrderId(order.getOrderId());
        orderCoffeeReponse.setOrdercoffees(orderCoffeesToOrderCoffeeResponseDtos(orderCoffees));


    }

    default List<OrderCoffeeReponse> orderCoffeesToOrderCoffeeResponseDtos(List<OrderCoffee> orderCoffees){
        return orderCoffees.stream()
                .map(a -> OrderCoffeeReponse
                        .builder()
                        .)
    };
}
