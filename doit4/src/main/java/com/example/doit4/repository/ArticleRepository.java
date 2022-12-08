package com.example.doit4.repository;

import com.example.doit4.entity.entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<entity,Long> {

}
