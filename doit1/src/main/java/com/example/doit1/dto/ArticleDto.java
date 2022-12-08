package com.example.doit1.dto;

import com.example.doit1.entity.ArticleEntity;

public class ArticleDto {
    private String title;
    private String content;

    public ArticleDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public ArticleEntity toEntity(){
        return new ArticleEntity(null,title,content);
    }
}
