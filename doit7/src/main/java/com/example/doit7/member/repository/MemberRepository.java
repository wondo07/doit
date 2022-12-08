package com.example.doit7.member.repository;

import com.example.doit7.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {



}
