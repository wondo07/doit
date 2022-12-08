package com.example.doit10.coffee.controller;


import com.example.doit10.coffee.dto.PatchCoffeeDto;
import com.example.doit10.coffee.dto.PostCoffeeDto;
import com.example.doit10.coffee.dto.ResponseCoffee;
import com.example.doit10.coffee.entity.Coffee;
import com.example.doit10.coffee.mapper.CoffeeMapper;
import com.example.doit10.coffee.service.CoffeeService;
import com.example.doit10.dto.AlltoDto;
import com.example.doit10.dto.SingleDto;
import com.example.doit10.member.dto.PageInfo;
import com.example.doit10.member.dto.PatchMemberDto;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeMapper coffeeMapper;

    @PostMapping
    public ResponseEntity post(@RequestBody PostCoffeeDto postCoffeeDto){
        Coffee coffee= coffeeMapper.DtotoEntity(postCoffeeDto);
        Coffee saved = coffeeService.saved(coffee);
        return new ResponseEntity<>(new SingleDto<>(coffeeMapper.EntitytoDto(saved)), HttpStatus.CREATED);
    }

    @PatchMapping("/{coffeeId}")
    public ResponseEntity patch(@RequestBody PatchCoffeeDto patchCoffeeDto,
                                @PathVariable Long coffeeId){
        Coffee coffee = coffeeMapper.patchtoEntity(patchCoffeeDto);
        Coffee saved = coffeeService.patch(coffeeId,coffee);
        return new ResponseEntity<>(
                new SingleDto<>(coffeeMapper.EntitytoDto(saved)), HttpStatus.OK);
    }

    @DeleteMapping("/{coffeeId}")
    public ResponseEntity delete(@PathVariable Long coffeeId){
        Coffee coffee = coffeeService.delete(coffeeId);
        return new ResponseEntity<>(
                new SingleDto<>(coffeeMapper.EntitytoDto(coffee)), HttpStatus.OK);
    }

    @GetMapping("/{coffeeId}")
    public ResponseEntity get(@PathVariable Long coffeeId){
        Coffee coffee = coffeeService.get(coffeeId);
        return new ResponseEntity<>(
                new SingleDto<>(coffeeMapper.EntitytoDto(coffee)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getcoffees(@RequestParam int page,
                                     @RequestParam int size){
        Page<Coffee> coffeePage = coffeeService.findCoffees(page-1,size);
        PageInfo pageInfo = new PageInfo(page,size,(int) coffeePage.getTotalElements(), coffeePage.getTotalPages());

        List<Coffee> coffees = coffeeService.findCoffees();
        List<ResponseCoffee> reponse = coffeeMapper.EntitytoDtos(coffees);
        return new ResponseEntity<>(new AlltoDto(reponse,pageInfo),HttpStatus.OK);
    }


}
