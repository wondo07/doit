package com.example.doit10.member.entity;

import com.example.doit10.member.service.MemberService;
import com.example.doit10.order.entity.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Column
    @Enumerated(value = EnumType.STRING)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    @OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST)
    List<Order> orderList=new ArrayList<>();


    public void patch(Member member) {
        if(email!=member.email){
            this.email= member.email;
        }
        if(name!=member.name){
            this.name= member.name;
        }
        if(phone!=member.phone){
            this.phone= member.phone;
        }
    }

    public enum MemberStatus{
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        MemberStatus(String status){
            this.status=status;
        }
    }
}
