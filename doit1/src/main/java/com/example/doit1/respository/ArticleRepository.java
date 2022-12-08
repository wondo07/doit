package com.example.doit1.respository;

import com.example.doit1.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<ArticleEntity,Long> {

    @Override
    ArrayList<ArticleEntity> findAll();
}
