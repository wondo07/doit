package com.example.doit7.member.mapper;

import com.example.doit7.member.dto.PatchMemberdto;
import com.example.doit7.member.dto.PostMemberdto;
import com.example.doit7.member.entity.Member;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel="spring")
public interface MemberMapper {



    Member PostEntity(PostMemberdto postMemberdto);

    Member PatchEntity(PatchMemberdto patchMemberdto);

}
