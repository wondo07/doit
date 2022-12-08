package com.example.doit5.order.OrderMapper;

import com.example.doit5.order.dto.OrderReponsedto;
import com.example.doit5.order.dto.PostOrderdto;
import com.example.doit5.order.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderdtotoentity(PostOrderdto postOrderdto);

    OrderReponsedto createddto(Order order);


}
