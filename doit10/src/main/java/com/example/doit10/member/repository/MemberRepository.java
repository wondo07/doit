package com.example.doit10.member.repository;

import com.example.doit10.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Page<Member> findAll(Pageable pageable);
}
