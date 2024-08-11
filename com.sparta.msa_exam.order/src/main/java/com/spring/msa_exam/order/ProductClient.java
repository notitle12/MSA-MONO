package com.spring.msa_exam.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/products/api/{id}")
    String getProduct(@PathVariable("id") String id);

//    @GetMapping("/products")
//    List<ProductResponseDto> getAllProducts();
//
//    @GetMapping("/products/{id}")
//    ProductResponseDto getProductById(@PathVariable("id") Long productId);
//
//    @PostMapping("/products")
//    ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto);
}

