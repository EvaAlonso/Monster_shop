package com.bootcam.Monster_shop.repository;

import com.bootcam.Monster_shop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
