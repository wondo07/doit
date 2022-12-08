package com.example.doit6.coffee.repository;

import com.example.doit6.coffee.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
}
