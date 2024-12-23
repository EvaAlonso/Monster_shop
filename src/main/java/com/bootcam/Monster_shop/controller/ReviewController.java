package com.bootcam.Monster_shop.controller;

import com.bootcam.Monster_shop.model.Product;
import com.bootcam.Monster_shop.model.Review;
import com.bootcam.Monster_shop.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }
    @GetMapping("api/reviews")
    public List<Review> getAllreviews(){
        return reviewService.getAll();
    }
    @GetMapping("api/reviews/{id}")
    public ResponseEntity<Review> findReviewById(@PathVariable long id){
        Optional<Review> foundReview = reviewService.findReview(id);

        if(foundReview.isPresent()){
            return new ResponseEntity<>(foundReview.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("api/reviews")
    public void createReview(@RequestBody Review newReview){
        reviewService.addReview(newReview);
    }
    @DeleteMapping("/api/reviews/{id}")
    public void deleteReviewById(@PathVariable long id){
        reviewService.deleteReview(id);
    }
    @PutMapping("/api/reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable long id, @RequestBody Review updateReview){
        try {
            Review review = reviewService.updatedReview(id, updateReview);
            return new ResponseEntity<>(review, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
