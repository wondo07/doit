package com.example.core1.member;

public class MemberServiceimpl implements MemberService{

    MemberRepository memberRepository=new MomoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findbyid(Long memberId) {
        return memberRepository.findbyId(memberId);
    }


}
