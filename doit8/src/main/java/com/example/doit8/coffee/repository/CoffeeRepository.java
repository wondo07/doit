package com.example.doit8.coffee.repository;

import com.example.doit8.coffee.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee,Long> {



}
