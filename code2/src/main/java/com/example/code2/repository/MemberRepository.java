package com.example.code2.repository;

import com.example.code2.member.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member,Long> {

    Optional<Member> findByEmail(String email);
}
