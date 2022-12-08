package com.example.doit2.dto;

import com.example.doit2.entity.entity;

public class dto {

    private Long id;
    private String title;
    private String content;

    public dto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public entity toEntity(){
        return new entity(id,title,content);

    }
}
