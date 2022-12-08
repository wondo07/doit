package com.example.doit10.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SingleDto <T>{
    private T data;
}
