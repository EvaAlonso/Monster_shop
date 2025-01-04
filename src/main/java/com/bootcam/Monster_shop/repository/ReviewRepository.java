package com.bootcam.Monster_shop.repository;

import com.bootcam.Monster_shop.model.Product;
import com.bootcam.Monster_shop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByProductId(long productId);
}
