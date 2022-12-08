package com.example.doit10.coffee.mapper;

import com.example.doit10.coffee.dto.PatchCoffeeDto;
import com.example.doit10.coffee.dto.PostCoffeeDto;
import com.example.doit10.coffee.dto.ResponseCoffee;
import com.example.doit10.coffee.entity.Coffee;
import com.example.doit10.member.dto.PatchMemberDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee DtotoEntity(PostCoffeeDto postCoffeeDto);

    ResponseCoffee EntitytoDto(Coffee saved);

    Coffee patchtoEntity(PatchCoffeeDto patchCoffeeDto);

    List<ResponseCoffee> EntitytoDtos(List<Coffee> coffees);
}
