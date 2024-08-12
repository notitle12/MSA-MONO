package com.spring.msa_exam.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order_products") // 테이블 이름을 order_products로 변경 (옵션)
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Long productId;

    // 제품 ID와 연관된 주문을 설정할 수 있는 생성자
    public OrderProduct(Long productId) {
        this.productId = productId;
    }
}
