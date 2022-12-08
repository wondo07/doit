package com.example.doit10.member.service;
import com.example.doit10.member.dto.PatchMemberDto;
import com.example.doit10.member.entity.Member;
import com.example.doit10.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member saved(Member member) {
        Member saved = memberRepository.save(member);
        return saved;
    }


    public Member patch(Member member, Long memberId) {
        Member oldmember = memberRepository.findById(memberId).orElse(null);
        oldmember.patch(member);
        Member saved = memberRepository.save(oldmember);
        return saved;
    }


    public Member delete(Long memberId) {
       Member member = memberRepository.findById(memberId).orElse(null);
       if(member != null){
           memberRepository.delete(member);
       }
       return member;
    }

    public Member get(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        return member;
    }

    public Page<Member> findMembers(int page,int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return memberRepository.findAll(pageRequest);
    }
    public List<Member> findMembers(){
        return (List<Member>) memberRepository.findAll(Sort.by(Sort.Direction.ASC,"memberId"));
    }
}
