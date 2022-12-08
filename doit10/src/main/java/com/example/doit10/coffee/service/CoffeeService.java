package com.example.doit10.coffee.service;

import com.example.doit10.coffee.entity.Coffee;
import com.example.doit10.coffee.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public Coffee saved(Coffee coffee) {

        Coffee saved = coffeeRepository.save(coffee);
        return saved;
    }

    public Coffee patch(Long coffeeId, Coffee coffee) {
        Coffee oldcoffee = coffeeRepository.findById(coffeeId).orElse(null);
        oldcoffee.patch(coffee);
        Coffee saved = coffeeRepository.save(oldcoffee);
        return saved;
    }

    public Coffee delete(Long coffeeId) {
        Coffee coffee = coffeeRepository.findById(coffeeId).orElse(null);
        coffeeRepository.delete(coffee);
        return coffee;
    }

    public Coffee get(Long coffeeId) {
        Coffee coffee = coffeeRepository.findById(coffeeId).orElse(null);
        return coffee;
    }

    public Page<Coffee> findCoffees(int page,int size){
        PageRequest pageRequest = PageRequest.of(page,size);
        return coffeeRepository.findAll(pageRequest);
    }

    public List<Coffee> findCoffees(){
        return (List<Coffee>) coffeeRepository.findAll(Sort.by(Sort.Direction.ASC,"coffeeId"));
    }

}
