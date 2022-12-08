package com.example.doit11.member.controller;

import com.example.doit11.dto.AllDto;
import com.example.doit11.dto.SingleDto;
import com.example.doit11.dto.PageInfo;
import com.example.doit11.member.dto.PatchMemberDto;
import com.example.doit11.member.dto.PostMemberDto;
import com.example.doit11.member.dto.ResponseMemberDto;
import com.example.doit11.member.entity.Member;
import com.example.doit11.member.mapper.MemberMapper;
import com.example.doit11.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberMapper memberMapper;

    @PostMapping
    public ResponseEntity post(@RequestBody PostMemberDto postMemberDto){
        Member member = memberMapper.post(postMemberDto);
        Member saved = memberService.saved(member);
        return new ResponseEntity<>(
                new SingleDto<>(memberMapper.memberDto(saved)), HttpStatus.CREATED);
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity patch(@PathVariable Long memberId,
                                @RequestBody PatchMemberDto patchMemberDto){
        Member member = memberMapper.patch(patchMemberDto);
        Member oldmember = memberService.patch(memberId,member);
        return new ResponseEntity<>(
                new SingleDto<>(memberMapper.memberDto(oldmember)), HttpStatus.OK);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity delete(@PathVariable Long memberId){
        Member member = memberService.delete(memberId);
        return new ResponseEntity<>(
                new SingleDto<>(memberMapper.memberDto(member)), HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity get(@PathVariable Long memberId){
        Member member = memberService.get(memberId);
        return new ResponseEntity<>(
                new SingleDto<>(memberMapper.memberDto(member)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getmember(@RequestParam int page,
                                    @RequestParam int size){
        Page<Member> memberPage = memberService.findMembers(page-1,size);
        PageInfo pageInfo = new PageInfo(page,size,(int) memberPage.getTotalElements(),memberPage.getTotalPages());

        List<Member> members =memberService.findMembers();
        List<ResponseMemberDto> response = memberMapper.MemberToResponse(members);

        return new ResponseEntity<>(new AllDto(response,pageInfo),HttpStatus.OK);

    }

}
