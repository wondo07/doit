package com.example.doit11.coffee.controller;

import com.example.doit11.coffee.dto.PatchCoffee;
import com.example.doit11.coffee.dto.PostCoffee;
import com.example.doit11.coffee.dto.ResponseCoffee;
import com.example.doit11.coffee.entity.Coffee;
import com.example.doit11.coffee.mapper.CoffeeMapper;
import com.example.doit11.coffee.service.CoffeeService;
import com.example.doit11.dto.AllDto;
import com.example.doit11.dto.PageInfo;
import com.example.doit11.dto.SingleDto;
import com.example.doit11.member.dto.PatchMemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeMapper coffeeMapper;
    @Autowired
    private CoffeeService coffeeService;

    @PostMapping
    public ResponseEntity post(@RequestBody PostCoffee postCoffee){
        Coffee coffee = coffeeMapper.post(postCoffee);
        Coffee saved = coffeeService.saved(coffee);
        return new ResponseEntity(
                new SingleDto<>(coffeeMapper.ToCoffeeDto(saved)), HttpStatus.CREATED);
    }

    @PatchMapping("/{coffeeId}")
    public ResponseEntity patch(@RequestBody PatchCoffee patchCoffee,
                                @PathVariable Long coffeeId){
        Coffee coffee = coffeeMapper.patch(patchCoffee);
        Coffee oldcoffee = coffeeService.patch(coffee, coffeeId);
        return new ResponseEntity<>(
                new SingleDto<>(coffeeMapper.ToCoffeeDto(oldcoffee)),HttpStatus.OK);
    }

    @DeleteMapping("/{coffeeId}")
    public ResponseEntity delete(@PathVariable Long coffeeId){
        Coffee coffee = coffeeService.delete(coffeeId);
        return new ResponseEntity<>(
                new SingleDto<>(coffeeMapper.ToCoffeeDto(coffee)),HttpStatus.OK);
    }

    @GetMapping("/{coffeeId}")
    public ResponseEntity get(@PathVariable Long coffeeId){
        Coffee coffee = coffeeService.get(coffeeId);
        return new ResponseEntity<>(
                new SingleDto<>(coffeeMapper.ToCoffeeDto(coffee)),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffee(@RequestParam int page,
                                    @RequestParam int size){
        Page<Coffee> coffeePage = coffeeService.findCoffees(page-1,size);
        PageInfo pageInfo = new PageInfo(page,size,(int) coffeePage.getTotalElements(),coffeePage.getTotalPages());

        List<Coffee> coffees=coffeeService.findCoffees();
        List<ResponseCoffee> response = coffeeMapper.ResponseCoffeeDto(coffees);

        return new ResponseEntity<>(new AllDto(response,pageInfo),HttpStatus.OK);
    }


}
