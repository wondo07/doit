package com.example.doit6.coffee.mapper;

import com.example.doit6.coffee.dto.PostCoffee;
import com.example.doit6.coffee.dto.ResponseCoffeeDto;
import com.example.doit6.coffee.entity.Coffee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperCoffee {
    Coffee dtotoentity(PostCoffee postCoffee);

    ResponseCoffeeDto entitytodto(Coffee coffee);
}
