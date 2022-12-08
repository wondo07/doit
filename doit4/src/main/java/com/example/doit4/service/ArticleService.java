package com.example.doit4.service;

import com.example.doit4.dto.PostDto;
import com.example.doit4.dto.UpdateDto;
import com.example.doit4.entity.entity;
import com.example.doit4.mapper.ArticleMapper;
import com.example.doit4.repository.ArticleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleMapper articleMapper;
    private final ArticleRepository articleRepository;


    public ArticleService(ArticleMapper articleMapper, ArticleRepository articleRepository) {
        this.articleMapper = articleMapper;
        this.articleRepository = articleRepository;
    }

    public entity input(PostDto postDto) {
        entity Entity = articleMapper.posttoentity(postDto);
        if(Entity != null){
            articleRepository.save(Entity);
        }
        return Entity;

    }

    public entity get(Long id) {
        entity Entity = articleRepository.findById(id).orElse(null);
        if (Entity == null){
            return null;
        }
        return Entity;

    }

    public List<entity> getlist() {
        List<entity> Entity = articleRepository.findAll();
        return Entity;
    }

    public entity patch(Long id, UpdateDto updateDto) {
        entity exEntity= articleRepository.findById(id).orElse(null);
        entity Entity = articleMapper.UpdatetoEntity(updateDto);
        if(id != updateDto.getId()){
            return null;
        }
        exEntity.patchentity(Entity);
        entity saved = articleRepository.save(exEntity);
        return saved;
    }


    public entity delete(Long id) {
        entity Entity = articleRepository.findById(id).orElse(null);
        if (Entity != null){
            articleRepository.delete(Entity);
        }
        return Entity;
    }
}
