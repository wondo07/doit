package com.example.doit8.member.mapper;

import com.example.doit8.member.dto.MemberResponse;
import com.example.doit8.member.dto.PatchMemberdto;
import com.example.doit8.member.dto.PostMemberdto;
import com.example.doit8.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface MemberMapper {



    Member PostEntity(PostMemberdto postMemberdto);

    Member PatchEntity(PatchMemberdto patchMemberdto);

    List<MemberResponse> membersToMemberResponseDtos(List<Member> members);
}
