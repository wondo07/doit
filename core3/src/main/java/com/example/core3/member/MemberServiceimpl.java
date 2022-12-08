package com.example.core3.member;

public class MemberServiceimpl implements MemberService{

    MemberRepository memberRepository;

    public MemberServiceimpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findbyId(Long memberId) {
        return memberRepository.findbyId(memberId);
    }
}
