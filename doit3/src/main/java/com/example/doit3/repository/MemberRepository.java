package com.example.doit3.repository;

import com.example.doit3.entity.entity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface MemberRepository extends CrudRepository<entity,Long> {

    @Override
    ArrayList<entity> findAll();
}
