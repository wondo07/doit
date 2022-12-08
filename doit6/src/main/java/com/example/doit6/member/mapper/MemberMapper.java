package com.example.doit6.member.mapper;

import com.example.doit6.member.dto.PatchMemberDto;
import com.example.doit6.member.dto.PostMemberDto;
import com.example.doit6.member.entity.Member;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member PostEntity(PostMemberDto postMemberDto);

    Member PatchEntity(PatchMemberDto patchMemberDto);
}
