package com.spring.msa_exam.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private Long product_id;
    private String name; // title을 name으로 변경
    private Integer supply_Price;

}