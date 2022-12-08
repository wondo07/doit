package com.example.doit6.order.mapper;

import com.example.doit6.order.dto.OrderReponseDto;
import com.example.doit6.order.dto.PostOrderDto;
import com.example.doit6.order.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order orderdtotoentity(PostOrderDto postOrderDto);

    OrderReponseDto createddto(Order order);

    OrderReponseDto entitytodto(Optional<Order> order);
}
