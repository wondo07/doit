package com.example.doit3.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Patchdto {

    private Long memberId;
    @NotBlank
    @Pattern(regexp="^[A-Za-z]*//s?[A-Za-z]*$")
    private String title;
    @NotBlank
    @Pattern(regexp="^[A-Za-z]*//s?[A-Za-z]*$")
    private String content;

    public Patchdto(Long memberId, String title, String content) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
    }
    public Patchdto(){
        return ;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
