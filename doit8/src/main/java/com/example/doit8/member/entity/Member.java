package com.example.doit8.member.entity;


import com.example.doit8.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "members")
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String phone;

    @OneToMany(mappedBy = "member")
    List<Order> orderList=new ArrayList<>();

//    @OneToMany(mappedBy = "member",cascade =CascadeType.PERSIST)
//    List<PostOrderDto> orderList=new ArrayList<>();

    public void patch(Member newmember) {
        if (email != newmember.email){
            this.email= newmember.email;
        }
        if(name!= newmember.name){
            this.name= newmember.name;
        }
        if(phone!= newmember.phone){
            this.phone= newmember.phone;
        }
    }

}
