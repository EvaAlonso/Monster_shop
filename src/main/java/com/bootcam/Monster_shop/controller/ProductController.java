package com.bootcam.Monster_shop.controller;

import com.bootcam.Monster_shop.model.Product;
import com.bootcam.Monster_shop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAll();
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable long id){
        Optional<Product> foundProduct = productService.findProduct(id);

        if(foundProduct.isPresent()){
            return new ResponseEntity<>(foundProduct.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/products")
    public void  createProduct(@RequestBody Product newProduct){
        productService.addProduct(newProduct);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable long id){
        productService.deleteProduct(id);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product updateProduct){
        try {
            Product product = productService.updatedProduct(id, updateProduct);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
