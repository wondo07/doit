package com.example.core1.member;

import java.util.HashMap;
import java.util.Map;

public class MomoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findbyId(Long memberId) {
        return store.get(memberId);
    }
}
