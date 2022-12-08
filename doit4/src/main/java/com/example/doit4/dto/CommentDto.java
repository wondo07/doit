package com.example.doit4.dto;

import com.example.doit4.entity.comment;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@NoArgsConstructor
public class CommentDto {

    private Long commentId;
    private String nickname;

    private String body;
    @JsonProperty("entity_id")
    private Long articleId;

    public static CommentDto createCommentdto(comment c) {
        return new CommentDto(
                c.getId(),
                c.getNickname(),
                c.getBody(),
                c.getEntity().getId()
        );
    }

    public static CommentDto createdComment(comment c) {
        return new CommentDto(
                c.getId(),
                c.getNickname(),
                c.getBody(),
                c.getEntity().getId()
        );
    }
}
