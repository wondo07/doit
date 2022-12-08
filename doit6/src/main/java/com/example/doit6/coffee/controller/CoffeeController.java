package com.example.doit6.coffee.controller;

import com.example.doit6.coffee.dto.PostCoffee;
import com.example.doit6.coffee.dto.ResponseCoffeeDto;
import com.example.doit6.coffee.entity.Coffee;
import com.example.doit6.coffee.mapper.MapperCoffee;
import com.example.doit6.coffee.repository.CoffeeRepository;
import com.example.doit6.coffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private MapperCoffee mapperCoffee;


    @PostMapping
    public ResponseEntity input(@RequestBody PostCoffee postCoffee){
        Coffee coffee = coffeeService.create(mapperCoffee.dtotoentity(postCoffee));
        ResponseCoffeeDto responseCoffeeDto = mapperCoffee.entitytodto(coffee);
        return (responseCoffeeDto != null)?
                ResponseEntity.status(HttpStatus.OK).body(responseCoffeeDto):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
