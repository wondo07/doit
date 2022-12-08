package com.example.core3.member;

public interface MemberRepository {

    void savd(Member member);
    Member findbyId(Long memberid);
}
