package com.example.doit5.order.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.JoinColumn;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PostOrderdto {

    private Long orderId;
//    private List<OrderCoffeedto> orderCoffees;
    @JsonProperty("member_id")
    private Long memberId;
}
