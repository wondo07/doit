package com.example.doit11.coffee.repository;

import com.example.doit11.coffee.entity.Coffee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee,Long> {

    Page<Coffee> findAll(Pageable pageable);

}
