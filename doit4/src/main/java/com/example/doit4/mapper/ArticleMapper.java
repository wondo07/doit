package com.example.doit4.mapper;


import com.example.doit4.dto.CommentDto;
import com.example.doit4.dto.PostDto;
import com.example.doit4.dto.UpdateDto;
import com.example.doit4.entity.comment;
import com.example.doit4.entity.entity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    entity posttoentity(PostDto postDto);
    entity UpdatetoEntity(UpdateDto updateDto);


}
