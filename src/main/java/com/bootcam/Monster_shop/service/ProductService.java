package com.bootcam.Monster_shop.service;

import com.bootcam.Monster_shop.model.Product;
import com.bootcam.Monster_shop.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final IProductRepository IProductRepository;

    public ProductService(IProductRepository IProductRepository ){
        this.IProductRepository = IProductRepository;
    }
    public List<Product> getAll(){
        return IProductRepository.findAll();
    }
    public Product addProduct(Product newProduct){
        return IProductRepository.save(newProduct);
    }
    public void deleteProduct(long id){
        IProductRepository.deleteById(id);
    }
    public Optional<Product> findProduct(long id){
        return IProductRepository.findById(id);
    }
    public Product updatedProduct(long id, Product updateProduct){
        Optional<Product> foundProduct = IProductRepository.findById(id);
        if(foundProduct.isPresent()){
            Product existingProduct = foundProduct.get();
             existingProduct.setName(updateProduct.getName());
             existingProduct.setPrice(updateProduct.getPrice());
             existingProduct.setImageUrl(updateProduct.getImageUrl());
             existingProduct.setRating(updateProduct.getRating());
             existingProduct.setReviewCount(updateProduct.getReviewCount());


             return IProductRepository.save(existingProduct);
        }
        throw new RuntimeException("Product not found with id: " + id);
    }


}
