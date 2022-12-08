package com.example.doit10.member.controller;

import com.example.doit10.dto.AlltoDto;
import com.example.doit10.dto.SingleDto;
import com.example.doit10.member.dto.PageInfo;
import com.example.doit10.member.dto.PatchMemberDto;
import com.example.doit10.member.dto.PostMemberDto;
import com.example.doit10.member.dto.ReponseDto;
import com.example.doit10.member.entity.Member;
import com.example.doit10.member.mapper.MemberMapper;
import com.example.doit10.member.service.MemberService;
import lombok.Getter;
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
    private MemberMapper memberMapper;
    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity post(@RequestBody PostMemberDto postMemberDto){
        Member member = memberMapper.DtotoEntity(postMemberDto);
        Member saved= memberService.saved(member);
        return new ResponseEntity<>(
                new SingleDto<>(memberMapper.reponse(saved)), HttpStatus.CREATED);
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity patch(@RequestBody PatchMemberDto patchMemberDto,
                                @PathVariable Long memberId){
        Member member = memberMapper.patchtoentity(patchMemberDto);
        Member saved = memberService.patch(member,memberId);
        return new ResponseEntity<>(
                new SingleDto<>(memberMapper.reponse(saved)), HttpStatus.OK);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity delete(@PathVariable Long memberId){
        Member member = memberService.delete(memberId);
        return new ResponseEntity<>(
                new SingleDto<>(memberMapper.reponse(member)), HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity get(@PathVariable Long memberId){
        Member member = memberService.get(memberId);
        return new ResponseEntity<>(
                new SingleDto<>(memberMapper.reponse(member)), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getmembers(@RequestParam int page,
                                     @RequestParam int size){
        Page<Member> memberPage = memberService.findMembers(page-1,size);
        PageInfo pageInfo = new PageInfo(page,size,(int) memberPage.getTotalElements(),memberPage.getTotalPages());

        List<Member> members=memberService.findMembers();
        List<ReponseDto> reponseDtos= memberMapper.memberstoDto(members);
        return new ResponseEntity<>(new AlltoDto(reponseDtos,pageInfo),HttpStatus.OK);

    }

}
