package com.example.doit10.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PageInfo {

    private int page;
    private int size;
    private int totalElement;
    private int totalPage;
}
