package com.example.doit4.repository;

import com.example.doit4.entity.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<comment,Long> {

    @Query(value = "select * from comment where entity_id=:articleId",nativeQuery = true)
    List<comment> findByAriticleId(Long articleId);

    @Query(value = "select * from comment where nickname=:nickname",nativeQuery = true)
    List<comment> findBynickname(String nickname);
}
