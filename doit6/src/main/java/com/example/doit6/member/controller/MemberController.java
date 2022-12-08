package com.example.doit6.member.controller;


import com.example.doit6.member.dto.PatchMemberDto;
import com.example.doit6.member.dto.PostMemberDto;
import com.example.doit6.member.entity.Member;
import com.example.doit6.member.service.MemberService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping("/member")
public class MemberController {



    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity input(@RequestBody PostMemberDto postMemberDto){
        Member member = memberService.DtotoEntity(postMemberDto);
        return (member != null)?
                ResponseEntity.status(HttpStatus.OK).body(member):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity patch(@PathVariable Long memberId, @RequestBody PatchMemberDto patchMemberDto){
        Member member = memberService.patch(memberId,patchMemberDto);
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
