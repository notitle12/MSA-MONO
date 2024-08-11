package com.spring.msa_exam.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private Long product_id;
    private String name; // title을 name으로 변경
    private Integer supply_Price;

    public ProductResponseDto(Product product) {
        this.product_id = product.getProduct_Id();
        this.name = product.getName(); // name 필드를 사용
        this.supply_Price = product.getSupply_Price();
    }
}