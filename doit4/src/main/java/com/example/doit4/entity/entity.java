package com.example.doit4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
//    @JsonIgnore
    @OneToMany(mappedBy = "Entity")
    List<comment> Comment= new ArrayList<comment>();

//
//    public void addcomment(comment Comment){
//        this.Comment.add(Comment);
//        if(Comment.getEntity() != this){
//            Comment.addComment(this);
//        }
//    }
    public void patchentity(entity entity) {
        if(title!=entity.title){
            this.title=entity.title;
        }
        if(content!=entity.content){
            this.content=entity.content;
        }
    }
}
