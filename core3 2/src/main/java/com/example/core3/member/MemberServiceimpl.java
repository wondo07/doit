package com.example.core3.member;

public class MemberServiceimpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceimpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.savd(member);
    }

    @Override
    public Member findbyId(Long memberid) {
        return memberRepository.findbyId(memberid);
    }
}
