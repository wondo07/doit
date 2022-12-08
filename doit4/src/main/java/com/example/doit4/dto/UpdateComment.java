package com.example.doit4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateComment {

    private Long id;

    private String nickname;

    private String body;
    @JsonProperty("entity_id")
    private Long articleId;
}
