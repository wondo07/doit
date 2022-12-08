package com.example.core3.member;

public interface MemberService {

    void join(Member member);
    Member findbyId(Long memberId);
}
