package com.example.doit.repository;

import com.example.doit.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article,Long> {

    @Override
    ArrayList<Article> findAll();
}
