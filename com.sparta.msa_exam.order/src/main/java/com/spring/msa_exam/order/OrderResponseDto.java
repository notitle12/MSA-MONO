package com.spring.msa_exam.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private Long orderId;
    private String name;
    private List<Long> productIds;

    // 생성자
    public OrderResponseDto(Long orderId, String name, List<Long> productIds) {
        this.orderId = orderId;
        this.name = name;
        this.productIds = productIds;
    }
}
