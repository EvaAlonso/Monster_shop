package com.bootcam.Monster_shop.service;

import com.bootcam.Monster_shop.model.Product;
import com.bootcam.Monster_shop.model.Review;
import com.bootcam.Monster_shop.repository.ProductRepository;
import com.bootcam.Monster_shop.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository ReviewRepository;
    private final ProductRepository ProductRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository, com.bootcam.Monster_shop.repository.ProductRepository productRepository1) {
        ReviewRepository = reviewRepository;
        ProductRepository = productRepository;
    }

    public List<Review> getAll(){
        return ReviewRepository.findAll();
    }
    //Tengo que buscar el producto por su id, asignar el producto a la reseña y guardar la reseña
    public Review addReview(Long productId,Review newReview){
        Product product = ProductRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found with id :" + productId));
        newReview.setProduct(product);
        return ReviewRepository.save(newReview);
    }
    public void deleteReview(long id){
        ReviewRepository.deleteById(id);
    }
    public Optional<Review> findReview(long id){
        return ReviewRepository.findById(id);
    }
    public Review updatedReview(long id, Review updateReview){
        Optional<Review> foundReview = ReviewRepository.findById(id);
        if(foundReview.isPresent()){
            Review existingReview = foundReview.get();
            existingReview.setUsername(updateReview.getUsername());
            existingReview.setRating(updateReview.getRating());
            existingReview.setBody(updateReview.getBody());

            return ReviewRepository.save(existingReview);
        }
        throw new RuntimeException("Review not found with id: " + id);
    }

}
