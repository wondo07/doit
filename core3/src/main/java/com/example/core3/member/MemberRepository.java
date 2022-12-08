package com.example.core3.member;

public interface MemberRepository {

    void save(Member member);
    Member findbyId(Long memberId);
}
