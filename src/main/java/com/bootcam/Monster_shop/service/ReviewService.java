package com.bootcam.Monster_shop.service;

import com.bootcam.Monster_shop.model.Product;
import com.bootcam.Monster_shop.model.Review;
import com.bootcam.Monster_shop.repository.IProductRepository;
import com.bootcam.Monster_shop.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository ReviewRepository;

    public ReviewService(com.bootcam.Monster_shop.repository.ReviewRepository reviewRepository) {
        ReviewRepository = reviewRepository;
    }

    public List<Review> getAll(){
        return ReviewRepository.findAll();
    }
    public Review addReview(Review newReview){
        return ReviewRepository.save(newReview);
    }

}
