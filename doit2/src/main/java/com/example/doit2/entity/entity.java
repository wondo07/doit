package com.example.doit2.entity;

import javax.persistence.*;


@Entity
public class entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public entity(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public entity(){
        return;
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

    @Override
    public String toString() {
        return "entity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


    public void patch(entity entity) {
        if(title != entity.getTitle()){
            this.title=entity.getTitle();
        }
        if(content!=entity.getContent()){
            this.content=entity.getContent();
        }
    }
}
