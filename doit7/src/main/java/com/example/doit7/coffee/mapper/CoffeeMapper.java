package com.example.doit7.coffee.mapper;

import com.example.doit7.coffee.dto.PostCoffeeDto;
import com.example.doit7.coffee.entity.Coffee;
import com.example.doit7.order.dto.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {

    Coffee toentity(PostCoffeeDto postCoffeeDto);

    OrderResponse EntitytoDto(Coffee coffee);
}
