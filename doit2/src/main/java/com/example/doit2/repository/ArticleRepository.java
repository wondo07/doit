package com.example.doit2.repository;

import com.example.doit2.entity.entity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<entity,Long> {

    @Override
    ArrayList<entity> findAll();


}
