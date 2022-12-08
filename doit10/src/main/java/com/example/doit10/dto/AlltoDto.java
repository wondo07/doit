package com.example.doit10.dto;


import com.example.doit10.member.dto.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AlltoDto<T> {
    private T data;
    private PageInfo pageInfo;


}
