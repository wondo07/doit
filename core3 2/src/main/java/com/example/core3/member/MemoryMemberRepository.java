package com.example.core3.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store=new HashMap<>();

    @Override
    public void savd(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findbyId(Long memberid) {
        return store.get(memberid);
    }
}
