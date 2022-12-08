package com.example.doit8.coffee.service;

import com.example.doit8.coffee.entity.Coffee;
import com.example.doit8.coffee.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;
    public Coffee save(Coffee coffee) {
        Coffee coffee1 = coffeeRepository.save(coffee);
        return coffee1;
    }

    public Coffee get(Long coffeeId) {
        Coffee coffee = coffeeRepository.findById(coffeeId).orElse(null);
        return coffee;
    }

    public Coffee delete(Long coffeeId) {
       Coffee coffee = coffeeRepository.findById(coffeeId).orElse(null);
       coffeeRepository.delete(coffee);
       return coffee;
    }
}
