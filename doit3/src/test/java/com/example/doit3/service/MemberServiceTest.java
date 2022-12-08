package com.example.doit3.service;

import com.example.doit3.entity.entity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    void get() {
        // 예상
        entity a=new entity(1L,"가가가","1111");
        entity b=new entity(2L,"나나나","2222");
        entity c=new entity(3L,"다다다","3333");
        ArrayList<entity> Entity = new ArrayList<entity>(Arrays.asList(a,b,c));
        // 실제
        List<entity> exentity = memberService.getall();
        // 비교
        assertEquals(Entity.toString(),exentity.toString());
    }

    @Test
    void testGet() {
        entity a=new entity(1L,"가가가","1111");
        entity exentity = memberService.get(1L);
        assertEquals(a.toString(),exentity.toString());
    }
}