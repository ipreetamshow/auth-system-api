package com.preetam.authsystem.controller;

import com.preetam.authsystem.dto.ApiResponse;
import com.preetam.authsystem.dto.ProductRequest;
import com.preetam.authsystem.dto.ProductResponse;
import com.preetam.authsystem.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Product APIs", description = "APIs for managing products")
public class ProductController {

    private final ProductService productService;

    // CREATE PRODUCT
    @Operation(summary = "Create a new product (Admin only)")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<ProductResponse> createProduct(
            @Valid @RequestBody ProductRequest request) {

        ProductResponse product = productService.createProduct(request);

        return new ApiResponse<>(
                true,
                "Product created successfully",
                product,
                LocalDateTime.now()
        );
    }

    // GET ALL PRODUCTS
    @Operation(summary = "Get all products with pagination and sorting")
    @GetMapping
    public ApiResponse<Page<ProductResponse>> getAllProducts(

            @PageableDefault(
                    page = 0,
                    size = 5,
                    sort = "name",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {

        Page<ProductResponse> products = productService.getAllProducts(pageable);

        return new ApiResponse<>(
                true,
                "Products fetched successfully",
                products,
                LocalDateTime.now()
        );
    }

    // GET PRODUCT BY ID
    @Operation(summary = "Get product details by ID")
    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> getProductById(@PathVariable Long id) {

        ProductResponse product = productService.getProductById(id);

        return new ApiResponse<>(
                true,
                "Product fetched successfully",
                product,
                LocalDateTime.now()
        );
    }

    // UPDATE PRODUCT
    @Operation(summary = "Update product details (Admin only)")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<ProductResponse> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {

        ProductResponse product = productService.updateProduct(id, request);

        return new ApiResponse<>(
                true,
                "Product updated successfully",
                product,
                LocalDateTime.now()
        );
    }

    // DELETE PRODUCT
    @Operation(summary = "Delete product by ID (Admin only)")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<String> deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return new ApiResponse<>(
                true,
                "Product deleted successfully",
                null,
                LocalDateTime.now()
        );
    }
}