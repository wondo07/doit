package com.example.doit10.member.mapper;

import com.example.doit10.member.dto.PatchMemberDto;
import com.example.doit10.member.dto.PostMemberDto;
import com.example.doit10.member.dto.ReponseDto;
import com.example.doit10.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member DtotoEntity(PostMemberDto postMemberDto);
    

    ReponseDto reponse(Member saved);

    Member patchtoentity(PatchMemberDto patchMemberDto);

    List<ReponseDto> memberstoDto(List<Member> members);
}
