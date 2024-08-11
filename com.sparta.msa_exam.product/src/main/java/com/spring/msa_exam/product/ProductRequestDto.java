package com.spring.msa_exam.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String name; // title을 name으로 변경

    private Integer supply_Price; // supply_price를 supplyPrice로 변경

}
