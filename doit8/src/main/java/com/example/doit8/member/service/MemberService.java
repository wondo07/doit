package com.example.doit8.member.service;

import com.example.doit8.member.dto.PatchMemberdto;
import com.example.doit8.member.dto.PostMemberdto;
import com.example.doit8.member.entity.Member;
import com.example.doit8.member.mapper.MemberMapper;
import com.example.doit8.member.repository.MemberRepository;
import com.example.doit8.member.dto.PatchMemberdto;
import com.example.doit8.member.dto.PostMemberdto;
import com.example.doit8.member.entity.Member;
import com.example.doit8.member.mapper.MemberMapper;
import com.example.doit8.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
    }

    public Page<Member> findMembers(int page, int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return memberRepository.findAll(pageRequest);
    }
    public List<Member> findMembers() {
        return (List<Member>) memberRepository.findAll(Sort.by(Sort.Direction.ASC,"memberId"));
    }

    public Member DtotoEntity(PostMemberdto postMemberdto) {
        Member member = memberMapper.PostEntity(postMemberdto);
        Member saved =memberRepository.save(member);
        return saved;
    }


    public Member patch(Long memberId, PatchMemberdto patchMemberdto) {
        Member member = memberRepository.findById(memberId).orElse(null);
        Member newmember = memberMapper.PatchEntity(patchMemberdto);
        if (memberId != patchMemberdto.getMemberId()){
            return null;
        }
        member.patch(newmember);
        Member saved = memberRepository.save(member);
        return saved;

    }

    public Member delete(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member ==null){
            return null;
        }
        memberRepository.delete(member);
        return member;
    }

    public Member get(Long memberId) {
        Member member =  memberRepository.findById(memberId).orElse(null);
        if (member ==null){
            return null;
        }
        return member;
    }

    public List<Member> getlist() {
        List<Member> memberList = memberRepository.findAll();
        if (memberList == null){
            return null;
        }
        return memberList;
    }
}
