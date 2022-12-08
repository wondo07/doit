package com.example.doit9.member.repository;

import com.example.doit9.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {



}
