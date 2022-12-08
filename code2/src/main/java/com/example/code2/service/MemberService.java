package com.example.code2.service;

import com.example.code2.exception.BusinessLogicException;
import com.example.code2.exception.ExceptionCode;
import com.example.code2.member.Member;
import com.example.code2.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member){
        verifyExistsEmail(member.getEmail());

        return memberRepository.save(member);
    }

    public Member updateMember(Member member){
        Member findMember = findVerifiedMember(member.getMemberId());
        Optional.ofNullable(member.getName())
                .ifPresent(name->findMember.setName(name));
        Optional.ofNullable(member.getPhone())
                .ifPresent(phone->findMember.setPhone(phone));

        return memberRepository.save(findMember);
    }

    public Member findMember(long memberId){
        return findVerifiedMember(memberId);
    }

    public List<Member> findMember(){
        return (List<Member>) memberRepository.findAll();
    }

    public void deleteMember(Long memberId){
        Member findMember = findVerifiedMember(memberId);
        memberRepository.delete(findMember);
    }

    public Member findVerifiedMember(Long memberId){
        Optional<Member> optionalMember=memberRepository.findById(memberId);
        Member findMember=optionalMember.orElseThrow(()->new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    private void verifyExistsEmail(String email){
        Optional<Member> member=memberRepository.findByEmail(email);
        if (member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

}
