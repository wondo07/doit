package com.example.doit6.coffee.service;

import com.example.doit6.coffee.entity.Coffee;
import com.example.doit6.coffee.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public Coffee create(Coffee coffee) {
           Coffee saved = coffeeRepository.save(coffee);
           return saved;
    }
}
