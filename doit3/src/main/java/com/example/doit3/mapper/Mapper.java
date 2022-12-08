package com.example.doit3.mapper;

import com.example.doit3.dto.Patchdto;
import com.example.doit3.dto.Postdto;
import com.example.doit3.entity.entity;
import org.springframework.stereotype.Component;


@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    entity postDtoToEntity(Postdto postdto);
    entity updateDtoToEntity(Patchdto patchdto);

}
