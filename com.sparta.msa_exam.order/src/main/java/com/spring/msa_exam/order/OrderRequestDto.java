package com.spring.msa_exam.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDto {
    private String name;
    private List<Long> productIds;


}
