package com.spring.msa_exam.order;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Order order = new Order(requestDto.getName());

        for (Long productId : requestDto.getProductIds()) {
            // Product 정보 가져오기
            ProductResponseDto product = productClient.getProductById(productId);

            // OrderProduct 생성
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setProductId(productId);
            orderProduct.setOrder(order); // 연관 관계 설정

            order.addProduct(orderProduct);
        }

        // Order 저장
        orderRepository.save(order);

        return new OrderResponseDto(
                order.getOrderId(),
                order.getName(),
                order.getProducts().stream()
                        .map(OrderProduct::getProductId)
                        .collect(Collectors.toList())
        );
    }

    public OrderResponseDto addProductToOrder(Long orderId, Long productId) {
        // Order 조회
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        // Product 정보 가져오기
        ProductResponseDto product = productClient.getProductById(productId);

        // 새로운 OrderProduct 생성 및 추가
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProductId(productId);
        orderProduct.setOrder(order); // 연관 관계 설정

        order.addProduct(orderProduct);

        // Order 저장
        orderRepository.save(order);

        // ResponseDto 반환
        return new OrderResponseDto(
                order.getOrderId(),
                order.getName(),
                order.getProducts().stream()
                        .map(OrderProduct::getProductId)
                        .collect(Collectors.toList())
        );
    }

    public OrderResponseDto getOrderById(Long orderId) {
        // Order 조회
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        // ResponseDto 반환
        return new OrderResponseDto(
                order.getOrderId(),
                order.getName(),
                order.getProducts().stream()
                        .map(OrderProduct::getProductId)
                        .collect(Collectors.toList())
        );
    }
}
