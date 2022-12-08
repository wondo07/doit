package com.example.doit8.coffee.controller;


import com.example.doit8.coffee.dto.PostCoffeeDto;
import com.example.doit8.coffee.entity.Coffee;
import com.example.doit8.coffee.mapper.CoffeeMapper;
import com.example.doit8.coffee.service.CoffeeService;
import com.example.doit8.dto.SingleResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeMapper coffeeMapper;

    @PostMapping
    public ResponseEntity post(@RequestBody PostCoffeeDto postCoffeeDto){
       Coffee coffee = coffeeMapper.toentity(postCoffeeDto);
       Coffee saved = coffeeService.save(coffee);
        return new ResponseEntity<>(
                new SingleResponseDto<>(coffeeMapper.EntitytoDto(saved)),
                HttpStatus.CREATED);
    }

    @GetMapping("/{coffeeId}")
    public ResponseEntity get(@PathVariable Long coffeeId){
        Coffee coffee = coffeeService.get(coffeeId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(coffeeMapper.EntitytoDto(coffee)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{coffeeId}")
    public ResponseEntity delete(@PathVariable Long coffeeId){
        Coffee coffee = coffeeService.delete(coffeeId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(coffeeMapper.EntitytoDto(coffee)),
                HttpStatus.OK);
    }
}
