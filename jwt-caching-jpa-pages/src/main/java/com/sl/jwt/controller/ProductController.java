package com.sl.jwt.controller;

import com.sl.jwt.domain.Product;
import com.sl.jwt.domain.Student;
import com.sl.jwt.dto.APIResponse;
import com.sl.jwt.service.APIService;
import com.sl.jwt.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
//ref: https://www.youtube.com/watch?v=Wa0GQwWwzJE
public class ProductController {

    @Autowired
    private ProductService productService;

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping(value = "/products")
    @ResponseBody
    public APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = productService.findAllProducts();
        //APIResponse apiResponse = new APIResponse<Product>(allProducts.size(), (Product) allProducts);

        return new APIResponse<>(allProducts.size(), allProducts);
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping(value = "/products/{field}")
    @ResponseBody
    public APIResponse<List<Product>> getProductsWithSorting(@PathVariable String field) {
        List<Product> allProducts = productService.findProductsWithSorting(field);
        //APIResponse apiResponse = new APIResponse<Product>(allProducts.size(), (Product) allProducts);

        return new APIResponse<>(allProducts.size(), allProducts);
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping(value = "/products/page/{offset}/{pageSize}")
    @ResponseBody
    public APIResponse<Page<Product>> getProductsWithSorting(@PathVariable int offset,@PathVariable int pageSize) {
        Page<Product> productsWithPagination = productService.findProductsWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping("/products/pageAndSort/{offset}/{pageSize}/{field}")
    @ResponseBody
    private APIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
        Page<Product> productsWithPagination = productService.findProductsWithPaginationAndSorting(offset, pageSize, field);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }
}

