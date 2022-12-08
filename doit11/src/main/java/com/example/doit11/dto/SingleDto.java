package com.example.doit11.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SingleDto <T>{
    private T data;
}
