package com.example.doit4.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "id")
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nickname;
    @Column
    private String body;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "entity_id")
    private entity Entity;


//    public void addComment(entity Entity){
//        this.Entity=Entity;
//        if (!this.Entity.getComment().contains(this)){
//            this.Entity.getComment().add(this);
//        }
//    }


    public void patch(comment newcomment) {
        if(nickname != newcomment.getNickname()){
            this.nickname= newcomment.getNickname();
        }
        if(body!= newcomment.getBody()){
            this.body= newcomment.getBody();
        }
    }
}
