package com.example.doit3.service;

import com.example.doit3.dto.Patchdto;
import com.example.doit3.dto.Postdto;
import com.example.doit3.entity.entity;
import com.example.doit3.mapper.Mapper;
import com.example.doit3.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final Mapper mapper;

    public MemberService(MemberRepository memberRepository, Mapper mapper) {
        this.memberRepository = memberRepository;
        this.mapper = mapper;
    }

    public entity post(Postdto postdto) {
        entity Entity = mapper.postDtoToEntity(postdto);
        if(Entity !=null){
            memberRepository.save(Entity);
        }

        return Entity;
    }

    public entity get(Long id) {
        entity Entity = memberRepository.findById(id).orElse(null);
        return Entity;
    }

    public ArrayList<entity> getall() {
        ArrayList<entity> Entity = memberRepository.findAll();
        return Entity;
    }

    public entity delete(Long id) {
        entity Entity = memberRepository.findById(id).orElse(null);
        if(Entity !=null){
            memberRepository.delete(Entity);
        }
        return Entity;
    }


    public entity patch(Long id, Patchdto patchdto) {
        entity exentity = memberRepository.findById(id).orElse(null);
        entity Entity = mapper.updateDtoToEntity(patchdto);
        if (id != Entity.getMemberId()){
            return null;
        }
        exentity.update(Entity);
        entity updated = memberRepository.save(exentity);
        return updated;
    }

    public entity findMember(long memberId) {
        // TODO should business logic

        // (1)
        throw new RuntimeException("Not found member");
    }
    @Transactional
    public List<entity> createArticles(List<Postdto> dtos) {
        List<entity> entityList  = dtos.stream()
                .map(dto1 -> mapper.postDtoToEntity(dto1))
                .collect(Collectors.toList());
        // entity 리스트를 DB에 저장
        entityList.stream()
                .forEach(entity1 -> memberRepository.save(entity1));

        // 강제 예외
        memberRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("결재 실패"));
        return entityList;
    }
}
