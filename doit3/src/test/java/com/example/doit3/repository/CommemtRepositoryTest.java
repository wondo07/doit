package com.example.doit3.repository;

import com.example.doit3.entity.Comment;
import com.example.doit3.entity.entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest //JPA와 연동한 테스트
class CommemtRepositoryTest {

    @Autowired
    CommemtRepository commemtRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조") //테스트 결과에 보여줄 이름
    void findByentityId() {
        // 입력 데이터 조회

        // 실제 수행
        List<Comment> comments = commemtRepository.findByentityId(4L);
        // 예상하기
        entity Entity =new entity(4L,"당신의 인생 영화는?","댓글 ㄱ");
        Comment a =new Comment(1L,Entity,"park","굳 헌팅");
        Comment b =new Comment(2L,Entity,"kim","아이 엠 샘");
        Comment c =new Comment(3L,Entity,"lee","범죄도시");
        List<Comment> expected = Arrays.asList(a,b,c);

        // 검증
        assertEquals(comments.toString(),expected.toString());


    }
}