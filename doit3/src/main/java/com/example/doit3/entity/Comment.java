package com.example.doit3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne  // 해당 댓글 엔티 여러개가 하나의 entity에 연관된다.
    @JoinColumn(name="article_id")
    private entity article;
    @Column
    private String nickname;
    @Column
    private String body;

}
