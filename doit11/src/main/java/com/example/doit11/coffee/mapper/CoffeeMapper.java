package com.example.doit11.coffee.mapper;


import com.example.doit11.coffee.dto.PatchCoffee;
import com.example.doit11.coffee.dto.PostCoffee;
import com.example.doit11.coffee.dto.ResponseCoffee;
import com.example.doit11.coffee.entity.Coffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee post(PostCoffee postCoffee);


    ResponseCoffee ToCoffeeDto(Coffee saved);

    Coffee patch(PatchCoffee patchCoffee);

    List<ResponseCoffee> ResponseCoffeeDto(List<Coffee> coffees);
}
