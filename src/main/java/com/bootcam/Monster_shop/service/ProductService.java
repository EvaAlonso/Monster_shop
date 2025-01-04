package com.bootcam.Monster_shop.service;

import com.bootcam.Monster_shop.model.Product;
import com.bootcam.Monster_shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository ProductRepository;

    public ProductService(ProductRepository IProductRepository ){
        this.ProductRepository = IProductRepository;
    }
    public List<Product> getAll(){
        return ProductRepository.findAll();
    }
    public Product addProduct(Product newProduct){
        return ProductRepository.save(newProduct);
    }
    public void deleteProduct(long id){
        ProductRepository.deleteById(id);
    }
    public Optional<Product> findProduct(long id){
        return ProductRepository.findById(id);
    }
    public Product updatedProduct(long id, Product updateProduct){
        Optional<Product> foundProduct = ProductRepository.findById(id);
        if(foundProduct.isPresent()){
            Product existingProduct = foundProduct.get();
             existingProduct.setName(updateProduct.getName());
             existingProduct.setPrice(updateProduct.getPrice());
             existingProduct.setImageUrl(updateProduct.getImageUrl());
             existingProduct.setFeatured(updateProduct.isFeatured());
             existingProduct.setReviewCount(updateProduct.getReviewCount());


             return ProductRepository.save(existingProduct);
        }
        throw new RuntimeException("Product not found with id: " + id);
    }


}
