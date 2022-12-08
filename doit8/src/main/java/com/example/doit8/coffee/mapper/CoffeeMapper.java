package com.example.doit8.coffee.mapper;

import com.example.doit8.coffee.dto.CoffeeResponse;
import com.example.doit8.coffee.dto.PostCoffeeDto;
import com.example.doit8.coffee.entity.Coffee;
import com.example.doit8.order.dto.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {

    Coffee toentity(PostCoffeeDto postCoffeeDto);

    CoffeeResponse EntitytoDto(Coffee coffee);
}
