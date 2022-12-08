package com.example.doit3.repository;

import com.example.doit3.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommemtRepository extends JpaRepository<Comment,Long> {

    @Query(value = "select * from comment where article_id =:id",nativeQuery = true)
    List<Comment> findByentityId(Long id);

    @Query(value = "select * from comment where nickname =:nickname",nativeQuery = true)
    List<Comment> findByenickname(String nickname);

}
