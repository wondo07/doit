package com.example.doit7.order.mapper;

import com.example.doit7.order.dto.OrderResponse;
import com.example.doit7.order.dto.PatchOrderDto;
import com.example.doit7.order.dto.PostOrderDto;
import com.example.doit7.order.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order PostEntity(PostOrderDto postOrderDto);

    Order PatchEntity(PatchOrderDto patchOrderDto);

    default OrderResponse EntitytoDto(Order saved){

    };
}
