package com.example.doit7.order.dto;


import com.example.doit7.coffee.dto.CoffeeResponse;
import com.example.doit7.coffee.repository.CoffeeRepository;
import lombok.*;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderCoffeeReponse {

    private Long ordercoffeeId;
    private Long coffeeId;
    private int quantity;
    private Long orderId;
    private List<CoffeeResponse> ordercoffees;
}
