package com.example.doit6.member.service;

import com.example.doit6.member.dto.PatchMemberDto;
import com.example.doit6.member.dto.PostMemberDto;
import com.example.doit6.member.entity.Member;
import com.example.doit6.member.mapper.MemberMapper;
import com.example.doit6.member.repository.MemberRepository;
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



    public Member DtotoEntity(PostMemberDto postMemberDto) {
        Member member = memberMapper.PostEntity(postMemberDto);
        Member saved =memberRepository.save(member);
        return saved;
    }


    public Member patch(Long memberId, PatchMemberDto patchMemberDto) {
        Member member = memberRepository.findById(memberId).orElse(null);
        Member newmember = memberMapper.PatchEntity(patchMemberDto);
        if (memberId != patchMemberDto.getMemberId()){
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
