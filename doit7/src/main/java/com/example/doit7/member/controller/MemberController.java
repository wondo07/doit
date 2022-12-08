package com.example.doit7.member.controller;

import com.example.doit7.member.dto.PatchMemberdto;
import com.example.doit7.member.dto.PostMemberdto;
import com.example.doit7.member.entity.Member;
import com.example.doit7.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {


    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity input(@RequestBody PostMemberdto postMemberdto){
        Member member = memberService.DtotoEntity(postMemberdto);
        return (member != null)?
                ResponseEntity.status(HttpStatus.OK).body(member):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity patch(@PathVariable Long memberId, @RequestBody PatchMemberdto patchMemberdto){
        Member member = memberService.patch(memberId,patchMemberdto);
        return (member != null)?
                ResponseEntity.status(HttpStatus.OK).body(member):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity delete(@PathVariable Long memberId){
        Member member = memberService.delete(memberId);
        return (member != null)?
                ResponseEntity.status(HttpStatus.OK).body(member):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity get(@PathVariable Long memberId){
        Member member = memberService.get(memberId);
        return (member != null)?
                ResponseEntity.status(HttpStatus.OK).body(member):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping
    public ResponseEntity<List<Member>> getlist(){
        List<Member> memberList = memberService.getlist();
        return (memberList != null)?
                ResponseEntity.status(HttpStatus.OK).body(memberList):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
