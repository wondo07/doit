package com.example.doit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor // 기본 생성
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id를 자동 생성하는 어노테이션
    private Long id;

    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article entity) {
        if(entity.title != null){
            this.title=entity.title;
        }
        if(entity.content!= null){
            this.content=entity.content;
        }
    }

//    public Article(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }

//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

}
