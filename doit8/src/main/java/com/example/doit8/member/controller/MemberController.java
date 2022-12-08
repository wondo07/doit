package com.example.doit8.member.controller;

import com.example.doit8.member.dto.*;
import com.example.doit8.member.entity.Member;
import com.example.doit8.member.mapper.MemberMapper;
import com.example.doit8.member.pageinfo.PageInfo;
import com.example.doit8.member.service.MemberService;
import com.example.doit8.member.dto.PatchMemberdto;
import com.example.doit8.member.dto.PostMemberdto;
import com.example.doit8.member.entity.Member;
import com.example.doit8.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberMapper memberMapper;
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
    public ResponseEntity getMembers(@RequestParam int page,
                                     @RequestParam int size) {

        Page<Member> memberPage=memberService.findMembers(page-1,size);
        PageInfo pageInfo = new PageInfo(page, size, (int) memberPage.getTotalElements(), memberPage.getTotalPages());

        List<Member> members = memberService.findMembers();
        List<MemberResponse> response = memberMapper.membersToMemberResponseDtos(members);

        return new ResponseEntity<>(new MemberAllDto(response,pageInfo), HttpStatus.OK);
    }

}
