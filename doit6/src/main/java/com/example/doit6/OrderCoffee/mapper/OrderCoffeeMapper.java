package com.example.doit6.OrderCoffee.mapper;

import com.example.doit6.OrderCoffee.dto.OrderCoffeeResponseDto;
import com.example.doit6.OrderCoffee.dto.PostOrderCoffeeDto;
import com.example.doit6.OrderCoffee.entity.OrderCoffee;
import com.example.doit6.order.dto.PostOrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderCoffeeMapper {
    OrderCoffee toentity(PostOrderCoffeeDto postOrderCoffeeDto);

    OrderCoffeeResponseDto coffeeToCoffeeResponseDto(OrderCoffee orderCoffee);

    OrderCoffeeResponseDto entitytodto(OrderCoffee orderCoffee);
}
