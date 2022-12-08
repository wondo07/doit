package com.example.doit3.entity;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
public class entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column
    private String title;
    @Column
    private String content;

    public entity(Long memberId, String title, String content) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public entity(){
        return ;
    }

    @Override
    public String toString() {
        return "entity{" +
                "memberId=" + memberId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void update(entity entity) {
        if(title != entity.getTitle()){
            title=entity.getTitle();
        }
        if(content != entity.getContent()){
            content=entity.getContent();
        }
    }
}
