package com.example.doit11.member.mapper;

import com.example.doit11.member.dto.ResponseMemberDto;
import com.example.doit11.member.dto.PatchMemberDto;
import com.example.doit11.member.dto.PostMemberDto;
import com.example.doit11.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {


    Member post(PostMemberDto postMemberDto);

    ResponseMemberDto memberDto(Member saved);

    Member patch(PatchMemberDto patchMemberDto);

    List<ResponseMemberDto> MemberToResponse(List<Member> members);
}
