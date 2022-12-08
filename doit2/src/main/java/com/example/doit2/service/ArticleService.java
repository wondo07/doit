package com.example.doit2.service;

import com.example.doit2.dto.dto;
import com.example.doit2.entity.entity;
import com.example.doit2.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // 서비스 객체를 스프링부트에 생성
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public ResponseEntity<ArrayList<entity>> article(){
        ArrayList<entity> Entity = articleRepository.findAll();
        if(Entity ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(Entity);
    }

    public entity save(dto dto) {
        entity Entity = dto.toEntity();
        if (Entity !=null){
            articleRepository.save(Entity);
        }
        return Entity;
    }


    public entity patch(dto dto, Long id) {
        entity Entity = dto.toEntity();
        entity exentity = articleRepository.findById(id).orElse(null);
        if(id!=Entity.getId()){
            return null;
        }
        exentity.patch(Entity);
        entity updated=articleRepository.save(exentity);
        return updated;
    }


    public entity delete(Long id) {
        entity Entity = articleRepository.findById(id).orElse(null);
        if(Entity ==null){
            return null;
        }
        articleRepository.delete(Entity);
        return Entity;
    }

    // 트랜잭션 -> 실패 -> 롤백!
//    @Transactional
    public List<entity> createArticles(List<dto> dtos) {
//        dto 리스트를 entity 리스트로 변환
        List<entity> entityList  = dtos.stream()
                .map(dto1 -> dto1.toEntity())
                .collect(Collectors.toList());
        // entity 리스트를 DB에 저장
        entityList.stream()
                .forEach(entity1 -> articleRepository.save(entity1));

        // 강제 예외
        articleRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("결재 실패"));
        return entityList;
    }


}
