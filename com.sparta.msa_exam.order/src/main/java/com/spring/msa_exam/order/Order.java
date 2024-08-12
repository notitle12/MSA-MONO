package com.spring.msa_exam.order;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders") // 테이블 이름을 orders로 변경
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String name;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> products = new ArrayList<>();

    // 주문 생성 시 이름을 받는 생성자
    public Order(String name) {
        this.name = name;
    }

    // 제품을 주문에 추가하는 메서드
    public void addProduct(OrderProduct product) {
        products.add(product);
        product.setOrder(this); // 양방향 연관 관계 설정
    }
}