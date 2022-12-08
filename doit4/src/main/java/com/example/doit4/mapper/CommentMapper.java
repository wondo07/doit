package com.example.doit4.mapper;

import com.example.doit4.dto.CommentDto;
import com.example.doit4.dto.UpdateComment;
import com.example.doit4.entity.comment;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper(componentModel = "spring")
public interface CommentMapper  {
    comment PostComment(CommentDto commentDto);
    comment updateComment(UpdateComment updateComment);
}
