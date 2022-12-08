package com.example.doit9.member.mapper;

import com.example.doit9.member.dto.PatchMemberdto;
import com.example.doit9.member.dto.PostMemberdto;
import com.example.doit9.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface MemberMapper {



    Member PostEntity(PostMemberdto postMemberdto);

    Member PatchEntity(PatchMemberdto patchMemberdto);

}
