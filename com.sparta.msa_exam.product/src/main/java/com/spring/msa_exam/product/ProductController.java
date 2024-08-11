package com.spring.msa_exam.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    @Value("${server.port}") // 애플리케이션이 실행 중인 포트를 주입받습니다.
    private String serverPort;

    private final ProductService productService;

    // 상품 생성 API
//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        try {
//            Product createdProduct = productService.createProduct(product);
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getName());
        product.setSupply_Price(productRequestDto.getSupply_Price());
        Product createdProduct = productService.createProduct(product);
        return new ProductResponseDto(createdProduct);
    }

    // 모든 상품 조회 API
//    @GetMapping
//    public ResponseEntity<List<Product>> getAllProducts() {
//        try {
//            List<Product> products = productService.getAllProducts();
//            return ResponseEntity.ok(products);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(ProductResponseDto::new)
                .toList();
    }

    // 특정 상품 조회 API
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable("id") Long product_id) {
//        try {
//            Optional<Product> product = productService.getProductById(product_id);
//            return product.map(ResponseEntity::ok)
//                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") Long product_id) {
        Product product = productService.getProductById(product_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ProductResponseDto(product);
    }

//    테스트
    @GetMapping("api/{id}")
    public String getProduct(@PathVariable String id) {
        return "Product id " + id + " From port : " + serverPort;
    }
}