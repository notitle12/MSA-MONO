package com.spring.msa_exam.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // 새로운 상품을 생성합니다
    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // 모든 상품을 조회합니다
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ID로 특정 상품을 조회합니다
    @Transactional(readOnly = true)
    public Optional<Product> getProductById(Long product_id) {
        return productRepository.findById(product_id);
    }
}
